package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortingAlNameTest {

    @Test
    public void compare(){
        SortingAlName sortingAlName = new SortingAlName();
        Client cl = new Client("Joana", "1234567890123456", "8/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        Client cl2 = new Client("David", "9876543210123456", "8/07/2001", "5432167890", "5432167890", "contribute2@geeksforgeeks.org", "98765432101", "Male");

       int result =  sortingAlName.compare(cl,cl2);

        assertEquals(1, result);
    }
    @Test
    public void compare2(){
        SortingAlName sortingAlName = new SortingAlName();
        Client cl = new Client("Joana", "1234567890123456", "8/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        Client cl2 = new Client("David", "9876543210123456", "8/07/2001", "5432167890", "5432167890", "contribute2@geeksforgeeks.org", "98765432101", "Male");

        int result =  sortingAlName.compare(cl2,cl2);

        assertEquals(0, result);
    }
    @Test
    public void compare3(){
        SortingAlName sortingAlName = new SortingAlName();
        Client cl = new Client("Joana", "1234567890123456", "8/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        Client cl2 = new Client("David", "9876543210123456", "8/07/2001", "5432167890", "5432167890", "contribute2@geeksforgeeks.org", "98765432101", "Male");

        int result =  sortingAlName.compare(cl2,cl);

        assertEquals(-1, result);
    }
}
