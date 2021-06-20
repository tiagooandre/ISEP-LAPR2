package app.domain.model;
/**
 *
 * @author Miguel Chen 1190897
 */
public class SortingAlTIN extends Client implements SortingAl{
    /**
     * compares clients TIN
     * @param o1 Client to be compared
     * @param o2 Client to be compared
     * @return integer of the compared objects
     */
    public int compare(Client o1, Client o2) {

        int result = o1.getTin().compareTo(o2.getTin());

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
