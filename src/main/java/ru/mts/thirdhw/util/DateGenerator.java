package ru.mts.thirdhw.util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateGenerator {
    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public static LocalDate generateDate() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, randBetween(1990, 2023));
        gc.set(Calendar.DAY_OF_YEAR, randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR)));
        return LocalDate.of(
                gc.get(Calendar.YEAR),
                gc.get(Calendar.MONTH),
                gc.get(Calendar.DAY_OF_MONTH)
        );

    }
}
