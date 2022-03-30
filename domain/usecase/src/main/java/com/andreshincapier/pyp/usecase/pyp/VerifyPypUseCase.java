package com.andreshincapier.pyp.usecase.pyp;

import static com.andreshincapier.pyp.model.util.DateFunction.getCurrentDayOfWeek;

import com.andreshincapier.pyp.model.digits.Digits;
import com.andreshincapier.pyp.model.digits.gateways.DigitsRepository;
import com.andreshincapier.pyp.model.dto.UserDigitsDTO;
import com.andreshincapier.pyp.model.user.User;
import com.andreshincapier.pyp.model.user.gateways.UserRepository;
import com.andreshincapier.pyp.model.whatsapp.MessageData;
import com.andreshincapier.pyp.model.whatsapp.gateways.WhatsAppRepository;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public record VerifyPypUseCase(UserRepository userRepository,
                               WhatsAppRepository whatsAppRepository,
                               DigitsRepository digitsRepository) {

    public Mono<Void> verifyPyp() {
        return Mono.just(getCurrentDayOfWeek())
            .flatMap(digitsRepository::findByToday)
            .map(digits -> UserDigitsDTO.builder()
                .digits(digits)
                .build()
            )
            .flatMap(digits -> userRepository.findAll()
                .collectList()
                .map(user -> digits.toBuilder()
                    .userList(user)
                    .build()
                )
            )
            .flatMapMany(ud -> filterByVehicleType(ud.getUserList(), ud.getDigits()))
            .map(this::buildMessage)
            .flatMap(whatsAppRepository::sendMessage)
            .then();
    }

    private MessageData buildMessage(User user) {
        return MessageData.builder()
            .phone(user.getPhone())
            .message("Hola ".concat("*" + user.getName() + "*")
                .concat(" tu vehículo con placa ")
                .concat("*" + user.getPlaque() + "*")
                .concat(" el dia de hoy le corresponde pico y placa")
            )
            .build();
    }


    private Flux<User> filterByVehicleType(List<User> user, Digits digits) {
        return Flux.fromIterable(user)
            .filter(usr -> usr.getType().equals("BIKE") && filterBike(usr, digits.getBikes()) ||
                usr.getType().equals("CAR") && filterCar(usr, digits.getCars())
            );
    }

    private boolean filterBike(User user, List<Integer> bikes) {
        return bikes
            .stream()
            .anyMatch(val -> val.equals(Character.getNumericValue(user.getPlaque().charAt(3))));
    }

    private boolean filterCar(User user, List<Integer> cars) {
        return cars
            .stream()
            .anyMatch(val -> val.equals(Character.getNumericValue(user.getPlaque().charAt(5))));
    }
}
