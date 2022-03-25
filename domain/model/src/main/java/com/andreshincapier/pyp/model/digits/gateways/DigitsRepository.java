package com.andreshincapier.pyp.model.digits.gateways;

import com.andreshincapier.pyp.model.digits.Digits;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DigitsRepository {

    Flux<Digits> findAll();
    Mono<Digits> findByToday(Integer today);
}
