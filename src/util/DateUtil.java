package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
    private static final String pattern = "yyyy-MM-dd";

    public static Date parseYYMMDD(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return new Date(sdf.parse(dateStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
