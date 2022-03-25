package com.andreshincapier.pyp.usecase.pyp;

import static com.andreshincapier.pyp.model.util.DateFunction.getCurrentDayOfWeek;

import com.andreshincapier.pyp.model.digits.Digits;
import com.andreshincapier.pyp.model.digits.gateways.DigitsRepository;
import com.andreshincapier.pyp.model.user.gateways.UserRepository;
import com.andreshincapier.pyp.model.whatsapp.gateways.WhatsAppRepository;
import reactor.core.publisher.Mono;

public record VerifyPypUseCase(UserRepository userRepository,
                               WhatsAppRepository whatsAppRepository,
                               DigitsRepository digitsRepository) {

    public Mono<Digits> verifyPyp() {
        return Mono.just(getCurrentDayOfWeek())
            .flatMap(digitsRepository::findByToday);
//        return whatsAppRepository.sendMessage("573052217854", "");
//        return userRepository.findByPlaque("WCM42C");
    }

}
