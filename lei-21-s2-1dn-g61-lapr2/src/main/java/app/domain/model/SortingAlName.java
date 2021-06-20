package app.domain.model;
/**
 *
 * @author Miguel Chen 1190897
 */

public class SortingAlName implements SortingAl {
    /**
     * compares clients Name
     * @param o1 Client to be compared
     * @param o2 Client to be compared
     * @return integer of the compared objects
     */
    public int compare(Client o1, Client o2) {

        int result = o1.getName().compareTo(o2.getName());

        if (result == 0) {

            return 0;
        } else {

            if (result > 0) {

                return 1;

            } else {

                return -1;

            }

        }
    }
}
