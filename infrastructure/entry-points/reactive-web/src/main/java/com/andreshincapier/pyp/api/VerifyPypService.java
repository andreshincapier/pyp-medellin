package com.andreshincapier.pyp.api;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

import com.andreshincapier.pyp.model.digits.Digits;
import com.andreshincapier.pyp.usecase.pyp.VerifyPypUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/pyp/api")
@AllArgsConstructor
public class VerifyPypService {

    private final VerifyPypUseCase verifyPypUseCase;

    @PostMapping(path = "/verify")
    public Mono<ResponseEntity<Digits>> verifyPypJob() {
        return verifyPypUseCase.verifyPyp()
            .map(value -> status(OK).body(value));
    }
}
