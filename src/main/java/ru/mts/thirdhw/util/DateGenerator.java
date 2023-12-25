package ru.mts.thirdhw.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DateGenerator {
    private static int randBetween(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

    public static LocalDate generateDate() {
        Calendar gc = new GregorianCalendar();
        int year = randBetween(1990, 2023);
        int month = randBetween(1, 12);
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month);
        gc.set(Calendar.DAY_OF_MONTH, randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_MONTH)));
        int day = gc.get(Calendar.DAY_OF_MONTH);

        return LocalDate.of(
                year,
                month,
                day
        );
    }
}
