package com.andreshincapier.pyp.model.util;

import java.util.Calendar;
import java.util.TimeZone;

public class DateFunction {

    private static final String ZONE_ID_BOGOTA = "America/Bogota";

    public static int getCurrentDayOfWeek() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ZONE_ID_BOGOTA));
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
