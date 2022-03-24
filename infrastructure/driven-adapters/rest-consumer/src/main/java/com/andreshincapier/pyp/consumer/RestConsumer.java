package com.andreshincapier.pyp.consumer;

import com.andreshincapier.pyp.model.whatsapp.MessageBody;
import com.andreshincapier.pyp.model.whatsapp.gateways.WhatsAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements WhatsAppRepository /* implements Gateway from domain */ {

    private final WebClient client;

    // these methods are an example that illustrates the implementation of WebClient.
    // You should use the methods that you implement from the Gateway from the domain.

    public Mono<MessageResponse> testGet() {

        return client
            .get()
            .retrieve()
            .bodyToMono(MessageResponse.class);

    }

    public Mono<MessageResponse> testPost() {

        MessageRequest request = MessageRequest.builder()
            .build();

        return client
            .post()
            .body(Mono.just(request), MessageRequest.class)
            .retrieve()
            .bodyToMono(MessageResponse.class);
    }

    @Override
    public Mono<String> sendMessage(String phone, String body) {

        MessageRequest request = MessageRequest.builder()
            .message("Hello from pyp service")
            .build();

        return client.post()
            .uri("/573052217854")
            .body(Mono.just(request), MessageRequest.class)
            .retrieve()
            .bodyToMono(String.class);
    }
}