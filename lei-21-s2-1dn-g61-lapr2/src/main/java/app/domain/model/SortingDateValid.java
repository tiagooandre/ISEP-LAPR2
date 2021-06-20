package app.domain.model;

import java.util.Comparator;

public class SortingDateValid implements Comparator<Test> {
    @Override
    public int compare(Test o1, Test o2) {
        int result = o1.getDateValidTest().compareTo(o2.getDateValidTest());
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
