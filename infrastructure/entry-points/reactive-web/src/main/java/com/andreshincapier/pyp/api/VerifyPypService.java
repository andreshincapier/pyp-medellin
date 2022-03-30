package com.andreshincapier.pyp.api;

import com.andreshincapier.pyp.model.user.User;
import com.andreshincapier.pyp.usecase.pyp.VerifyPypUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/pyp/api")
@AllArgsConstructor
public class VerifyPypService {

    private final VerifyPypUseCase verifyPypUseCase;

    @PostMapping(path = "/verify")
    public Flux<User> verifyPypJob() {
        return verifyPypUseCase.verifyPyp();
    }

//    @PostMapping(path = "/verify")
//    public Flux<ResponseEntity<User>> verifyPypJob() {
//        return verifyPypUseCase.verifyPyp()
//            .map(value -> status(OK).body(value));
//    }
}
