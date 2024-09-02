package utilitaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final String format = "dd/MM/yyyy";

    public static Date StringToDate(String dateStr)throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        return sdf.parse(dateStr);
    }
    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    public static boolean isValidDate(String dateStr) {
        try {
            StringToDate(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }



}
