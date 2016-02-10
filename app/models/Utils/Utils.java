package models.Utils;

import java.util.List;

/**
 * Created by Guillaume on 10/02/2016.
 */
public class Utils {

    public static <T> boolean isEqualList(List<T> l1, List<T> l2){
        return (l1!=null && l2!= null && l1.containsAll(l2)
                && l2.containsAll(l1) && l1.size()==l2.size());
    }
}
