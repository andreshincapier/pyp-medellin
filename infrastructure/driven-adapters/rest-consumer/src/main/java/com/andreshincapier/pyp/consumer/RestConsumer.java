package com.andreshincapier.pyp.consumer;

import com.andreshincapier.pyp.model.whatsapp.gateways.WhatsAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements WhatsAppRepository {

    private final WebClient client;

    @Override
    public Mono<String> sendMessage(String phone, String message) {

        MessageRequest request = MessageRequest.builder()
            .message("Hello from pyp service")
            .build();

        return client.post()
            .uri(phone)
            .body(Mono.just(request), MessageRequest.class)
            .retrieve()
            .bodyToMono(String.class);
    }
}