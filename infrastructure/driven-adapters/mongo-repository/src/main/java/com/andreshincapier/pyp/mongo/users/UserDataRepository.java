package com.andreshincapier.pyp.mongo.users;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserDataRepository extends ReactiveCrudRepository<UsersData, String>,
    ReactiveQueryByExampleExecutor<UsersData> {

    Mono<UsersData> findByPlaque(String plaque);

}
