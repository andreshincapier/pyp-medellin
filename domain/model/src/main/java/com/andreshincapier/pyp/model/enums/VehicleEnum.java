package com.andreshincapier.pyp.model.enums;

import java.util.Arrays;

public enum VehicleEnum {

    BIKE(""),
    CAR("");

    private final String id;

    VehicleEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static String nameFromId(String id) {
        return Arrays.stream(values())
            .filter(dse -> dse.getId().equals(id))
            .map(Enum::name)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("OBJECT_STATUS_NOT_VALID"));
    }
}
