package com.andreshincapier.pyp.consumer;

import com.andreshincapier.pyp.model.whatsapp.MessageData;
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
    public Mono<String> sendMessage(MessageData data) {

        MessageRequest request = MessageRequest.builder()
            .message(data.getMessage())
            .build();

        return client.post()
            .uri(data.getPhone())
            .body(Mono.just(request), MessageRequest.class)
            .retrieve()
            .bodyToMono(String.class);
    }
}