package com.andreshincapier.pyp.model.whatsapp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MessageBody {

    private String message;

}
