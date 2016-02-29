package models.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Guillaume on 10/02/2016.
 */
public class Utils {

    /**
     * Teste si les deux listes passées en parametre sont égales
     * @param l1
     * @param l2
     * @param <T>
     * @return
     */
    public static <T> boolean isEqualList(List<T> l1, List<T> l2){
        return (l1!=null && l2!= null && l1.containsAll(l2)
                && l2.containsAll(l1) && l1.size()==l2.size());
    }

    /**
     * Retourne un objet java.util.Date, avec l'année, le mois et le jour passé en parametre
     * heure =0 ,minutes =0 et secondes = 0
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDateFrom(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);

        return cal.getTime();
    }

    /**
     * Calcule le nombre de jours entre date1 et date2 : date2-date1
     * @param date1
     * @param date2
     * @return
     */
    public static long differenceNbJours(Date date1, Date date2) {
        return ((date2.getTime() - date1.getTime()) / 86400000);
    }

}
