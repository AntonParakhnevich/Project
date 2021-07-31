package Project.Localization;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by .
 */
public final class ProjectLocal {
    private static final Map<String, Locale> LOCALES = new HashMap<>();

    static {
        LOCALES.put("eng", new Locale("en", "US"));
        LOCALES.put("rus", new Locale("ru", "RU"));
    }

    public static Locale getLocale(String language) {
        return LOCALES.containsKey(language) ? LOCALES.get(language) : Locale.getDefault();
    }
}
