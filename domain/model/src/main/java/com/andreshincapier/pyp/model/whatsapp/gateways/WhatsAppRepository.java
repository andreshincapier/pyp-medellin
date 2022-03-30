package com.andreshincapier.pyp.model.whatsapp.gateways;

import com.andreshincapier.pyp.model.whatsapp.MessageData;
import reactor.core.publisher.Mono;

public interface WhatsAppRepository {

    Mono<String> sendMessage(MessageData messageData);

}
