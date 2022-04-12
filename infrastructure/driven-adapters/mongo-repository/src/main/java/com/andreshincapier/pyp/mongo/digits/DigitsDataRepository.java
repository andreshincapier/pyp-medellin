package com.andreshincapier.pyp.mongo.digits;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface DigitsDataRepository extends ReactiveCrudRepository<DigitsData, String>,
    ReactiveQueryByExampleExecutor<DigitsData> {

    Mono<DigitsData> findByDay(Integer today);

}
