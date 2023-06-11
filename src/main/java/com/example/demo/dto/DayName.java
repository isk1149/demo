package com.example.demo.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DayName {
    public static String getDayName() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        Map<Integer, String> day = new HashMap<>();
        //day.put(dayOfWeek.getValue(), dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREA));
        //day.put(dayOfWeek.getValue(), dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREA));
        //day.put(dayOfWeek.getValue(), dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US));
        return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);
    }
}
