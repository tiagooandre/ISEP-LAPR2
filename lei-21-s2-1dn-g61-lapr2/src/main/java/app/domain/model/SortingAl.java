package app.domain.model;

import java.util.Comparator;
/**
 *
 * @author Miguel Chen 1190897
 */
public interface SortingAl extends Comparator<Client> {
     /**
      *
      * @param o1 Client to be compared
      * @param o2 Client to be compared
      * @return integer of the compared objects
      */
     public int compare(Client o1, Client o2);
}
