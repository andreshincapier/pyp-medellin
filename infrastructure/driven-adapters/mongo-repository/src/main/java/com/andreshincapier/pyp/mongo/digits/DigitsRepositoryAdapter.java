package com.andreshincapier.pyp.mongo.digits;

import com.andreshincapier.pyp.model.digits.Digits;
import com.andreshincapier.pyp.model.digits.gateways.DigitsRepository;
import com.andreshincapier.pyp.mongo.config.AdapterOperations;
import lombok.extern.slf4j.Slf4j;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class DigitsRepositoryAdapter extends
    AdapterOperations<Digits, DigitsData, String, DigitsDataRepository> implements
    DigitsRepository {

    @Autowired
    public DigitsRepositoryAdapter(DigitsDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Digits.DigitsBuilder.class).build());
    }

    @Override
    public Flux<Digits> findAll() {
        return doQueryMany(repository.findAll());
    }

    @Override
    public Mono<Digits> findByToday(Integer today) {
        return doQuery(repository.findByDay(today));
    }
}
