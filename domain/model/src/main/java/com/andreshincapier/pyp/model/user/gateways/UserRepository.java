package com.andreshincapier.pyp.model.user.gateways;

import com.andreshincapier.pyp.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> findById(String id);
    Mono<User> save(User mutants);
    Mono<User> findByPlaque(String plaque);

}
