package com.andreshincapier.pyp.usecase.pyp;

import com.andreshincapier.pyp.model.user.gateways.UserRepository;
import com.andreshincapier.pyp.model.whatsapp.gateways.WhatsAppRepository;
import reactor.core.publisher.Mono;

public record VerifyPypUseCase(UserRepository userRepository,
                               WhatsAppRepository whatsAppRepository) {

    public Mono<String> verifyPyp() {
        return whatsAppRepository.sendMessage("", "");
//        return userRepository.findByPlaque("WCM42C");
    }
}
