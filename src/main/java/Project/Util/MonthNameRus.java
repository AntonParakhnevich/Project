package Project.Util;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by .
 */
public final class MonthNameRus {

    private static final Map<Month, String> MONTHS = new HashMap<>();

    static {
        MONTHS.put(Month.JANUARY, "январь");
        MONTHS.put(Month.FEBRUARY, "февраль");
        MONTHS.put(Month.MARCH, "март");
        MONTHS.put(Month.APRIL, "апрель");
        MONTHS.put(Month.MAY, "май");
        MONTHS.put(Month.JUNE, "июнь");
        MONTHS.put(Month.JULY, "июль");
        MONTHS.put(Month.AUGUST, "август");
        MONTHS.put(Month.SEPTEMBER, "сентябрь");
        MONTHS.put(Month.OCTOBER, "октябрь");
        MONTHS.put(Month.NOVEMBER, "ноябрь");
        MONTHS.put(Month.DECEMBER, "декабрь");
    }

    private MonthNameRus() {
    }

    public static String getNameMonth(Month month){
        return MONTHS.get(month);
    }

}
