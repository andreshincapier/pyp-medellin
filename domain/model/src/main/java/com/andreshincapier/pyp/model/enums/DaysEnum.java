package com.andreshincapier.pyp.model.enums;

import java.util.Arrays;

public enum DaysEnum {

    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    private final int id;

    DaysEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static String nameFromId(int id) {
        return Arrays.stream(values())
            .filter(dse -> dse.getId() == id)
            .map(Enum::name)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("OBJECT_STATUS_NOT_VALID"));
    }
}
