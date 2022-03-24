package com.andreshincapier.pyp.model.whatsapp.gateways;

import reactor.core.publisher.Mono;

public interface WhatsAppRepository {

    Mono<String> sendMessage(String phone, String message);

}
