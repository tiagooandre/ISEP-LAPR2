package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortingDateValidTest {

    @Test
    public void compare(){
       SortingDateValid sortingDateValid = new SortingDateValid();
        String nh = "123456789012";
        String nh2 = "123456789021";
        app.domain.model.Test test = new app.domain.model.Test(nh);
        app.domain.model.Test test2 = new app.domain.model.Test(nh2);
        test.setDateValidTest();
        test2.setDateValidTest();

        int result =  sortingDateValid.compare(test,test2);

        assertEquals(0, result);
    }

}
