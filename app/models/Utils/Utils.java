package models.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Guillaume on 10/02/2016.
 */
public class Utils {

    public static <T> boolean isEqualList(List<T> l1, List<T> l2){
        return (l1!=null && l2!= null && l1.containsAll(l2)
                && l2.containsAll(l1) && l1.size()==l2.size());
    }

    public static Date getDateFrom(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }
}
