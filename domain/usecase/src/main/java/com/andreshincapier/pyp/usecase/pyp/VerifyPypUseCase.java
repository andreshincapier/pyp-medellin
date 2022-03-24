package com.andreshincapier.pyp.usecase.pyp;

import com.andreshincapier.pyp.model.user.User;
import com.andreshincapier.pyp.model.user.gateways.UserRepository;
import reactor.core.publisher.Mono;

public record VerifyPypUseCase(UserRepository userRepository) {

    public Mono<User> verifyPyp() {
        return userRepository.findByPlaque("WCM42C");
    }
}
