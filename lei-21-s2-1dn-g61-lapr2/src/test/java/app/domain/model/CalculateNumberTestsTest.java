package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateNumberTestsTest {

    CalculateNumberTests cnt = new CalculateNumberTests();
    Date beginDate = new Date("16/6/2021");
    Date endDate = new Date("18/6/2021");
    Date beginDate1 = new Date("16/6/2010");
    Date endDate2 = new Date("16/6/2021");
    Date endDate3 = new Date("16/3/2021");

    @Test
    public void getNumberRegisteredTestsInterval() {

    }

    @Test
    public void getNumberRegisteredTests() {
    }

    @Test
    public void testCheckInterval2() {
        System.out.println("Same month");
        boolean result = cnt.checkInterval(beginDate, endDate, "month");
        assertTrue(result);
    }

    @Test
    public void testCheckInterval3() {
        System.out.println("Same year");
        boolean result = cnt.checkInterval(beginDate, endDate, "year");
        assertTrue(result);
    }

    @Test
    public void testCheckInterval4() {
        System.out.println("Same month, different year");
        boolean result = cnt.checkInterval(beginDate1, endDate2, "month");
        assertFalse(result);
    }

    @Test
    public void testCheckInterval5() {
        System.out.println("Same day, different year");
        boolean result = cnt.checkInterval(beginDate1, endDate2, "day");
        assertFalse(result);
    }

    @Test
    public void testCheckInterval6() {
        System.out.println("Same day, different month");
        boolean result = cnt.checkInterval(endDate2, endDate3, "day");
        assertFalse(result);
    }

    @Test
    public void testCheckInterval7() {
        System.out.println("Same day");
        boolean result = cnt.checkInterval(endDate2, endDate2, "day");
        assertTrue(result);
    }

    @Test
    public void testCheckInterval8() {
        System.out.println("Same week");
        boolean result = cnt.checkInterval(endDate2, endDate3, "week");
        assertFalse(result);
    }

    @Test
    public void testCheckInterval9() {
        System.out.println("Same week");
        boolean result = cnt.checkInterval(endDate2, endDate2, "week");
        assertTrue(result);
    }

    @Test
    public void testCheckInterval10() {
        System.out.println("Same week");
        boolean result = cnt.checkInterval(endDate3, endDate2, "week");
        assertFalse(result);
    }
}