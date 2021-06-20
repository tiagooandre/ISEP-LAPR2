package app.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class TimeTest {

    @Test
    public void testContructor1(){
        Time time = new Time("18:53");

        int hours = time.getHours();

        int expected1 = 18;
        assertEquals(expected1, hours);
    }

    @Test
    public void testContructor2(){
        Time time = new Time("18:53");

        int minutes = time.getMinutes();

        int expected2 = 53;
        assertEquals(expected2, minutes);
    }
    /**
     * Test 1: getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        
        Time instance=new Time();
        int expected= instance.getHours();
        int result = instance.getHours();
        
        assertEquals(expected, result);
    }

    /**
     * Test 2: getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        
        Time instance=new Time();
        int expected= instance.getMinutes();
        int result = instance.getMinutes();
        
        assertEquals(expected, result);
    }

    /**
     * Test 3: getSeconds method, of class Time.
     */
    @Test
    public void testGetSeconds() {
        System.out.println("getSeconds");
        
        Time instance=new Time();
        int expected= instance.getSeconds();
        int result = instance.getSeconds();
        
        assertEquals(expected, result);
    }

    /**
     * Test 4: setTime method, of class Time.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        

        Time instance=new Time();
        instance.setTime();
        boolean result = (instance.getHours()!=26 && instance.getMinutes()!=78 && instance.getSeconds()!=97);
        
        assertTrue(result);
    }

    @Test
    public void testCompareTo(){
        Time t = new Time();
        Time t2 = new Time();
        assertEquals(0, t.compareTo(t2));

    }

   /* *//**
     * Test 5: toStringHHMMSS method, of class Time.
     *//*
    @Test
    public void testToString() {
        System.out.println("toStringHHMMSS");
        
        Time instance=new Time();
        String expected = instance.getHours() + ":" + instance.getMinutes() + ":" + instance.getSeconds();
        String result = instance.toString();
       
        assertEquals(expected, result);
    }
*/
    
}
