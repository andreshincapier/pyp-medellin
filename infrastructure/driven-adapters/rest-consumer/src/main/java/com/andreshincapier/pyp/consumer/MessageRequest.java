package com.andreshincapier.pyp.consumer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MessageRequest {

    private String message;

}
