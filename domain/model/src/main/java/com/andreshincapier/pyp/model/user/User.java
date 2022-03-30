package com.andreshincapier.pyp.model.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class User {

    private String name;
    private String phone;
    private String type;
    private String plaque;
}
