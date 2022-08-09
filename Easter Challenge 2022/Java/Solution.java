package de.entwicklerheld.easterChallenge2022Java;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EasterChallenge2022Java {
    public static Calendar calculateEasterSunday(int year) {
        int a, b, c, d, e, f, g, h, i, j, k, l, month, day;
        
        a = year % 19;
        b = year / 100;
        c = year % 100;
        d = b / 4;
        e = b % 4;
        f = (8 * b + 13) / 25;
        g = (19 * a + b - d - f + 15) % 30;
        h = c / 4;
        i = c % 4;
        j = (a + 11 * g) / 319;
        k = (2 * e + 2 * h - i - g + j + 32) % 7;
        month = (g - j + k + 90) / 25;
        day = (g - j + k + month + 19) % 32;

        Calendar easterSunday = Calendar.getInstance();
        easterSunday.set(year, month-1, day);

        return easterSunday;
    }

    public static List<Calendar> calculateEasterDays(int year) {
    
        Calendar easterSunday = calculateEasterSunday(year);

        Calendar easterFriday = (Calendar)easterSunday.clone();
        easterFriday.add(Calendar.DAY_OF_MONTH, -2);

        Calendar easterMonday = (Calendar)easterSunday.clone();
        easterMonday.add(Calendar.DAY_OF_MONTH, 1);

        List<Calendar> easterDays = new ArrayList<>();
        easterDays.add(easterFriday);
        easterDays.add(easterSunday);
        easterDays.add(easterMonday);
        
        return easterDays;
    }
}