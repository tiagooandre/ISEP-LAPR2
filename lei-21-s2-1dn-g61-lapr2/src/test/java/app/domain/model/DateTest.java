/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class DateTest {

    Date beginDate = new Date("16/6/2021");
    Date endDate = new Date("18/6/2021");
    Date beginDate1 = new Date("16/6/2010");
    Date endDate2 = new Date("18/6/2021");

    @Test
    public void testContructor1(){
        Date date = new Date("22/03/2021");

        int day = date.getDay();

        int expected1 = 22;
        assertEquals(expected1, day);
    }

    @Test
    public void testContructor2(){
        Date date = new Date("22/03/2021");

        int month = date.getMonth();

        int expected1 = 03;
        assertEquals(expected1, month);
    }

    @Test
    public void testContructor3(){
        Date date = new Date("22/03/2021");

        int year = date.getYear();

        int expected1 = 2021;
        assertEquals(expected1, year);
    }

    /**
     * Test 1: getYear method, of class Date.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        
        Date instance=new Date();
        int expected=2021;
        int result = instance.getYear();
        
        assertEquals(expected, result);
    }

    /**
     * Test 2: getMes method, of class Date.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMes");
        
        Date instance=new Date();
        int expected=instance.getMonth();
        int result = instance.getMonth();
        
        assertEquals(expected, result);
    }

    /**
     * Test 3: getDay method, of class Date.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        
        Date instance=new Date();
        int expected= instance.getDay();
        int result = instance.getDay();
        
        assertEquals(expected, result);
    }

  /*  *//**
     * Test 4: setDate method, of class Date.
     *//*
    @Test
    public void testSetDate() {
        System.out.println("setDate");

        Date instance=new Date();
        instance.setDate();

        assertTrue(instance.getYear()!= 2000);
        
    }*/

    /**
     * Test 5: toString method, of class Date.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Date instance=new Date();
        String expected = instance.getDay() + " " + instance.getMonth() + " " + instance.getYear();
        String result = instance.toString();
       
        assertEquals(expected, result);
    }

    /**
     * Test 6: toYMDString method, of class Date.
     */
    @Test
    public void testToYMDString() {
        System.out.println("toYMDString");
        
        Date instance=new Date();
        String expected = instance.toYMDString();
        String result = instance.toYMDString();
        
        assertEquals(expected, result);
    }

    @Test
    public void testCompareTo(){
        Date d = new Date();
        Date d2 = new Date();
        assertEquals(0, d.compareTo(d2));

    }

    @Test
    public void testCompareTo2(){
        Date d = new Date();
        Date d2 = new Date();
        assertEquals(0, d.compareTo(d2));

    }

    @Test
    public void testCalculateDifference() {
        System.out.println("calculateDifference");
        int result = beginDate.calculateDifference(endDate);
        System.out.println(result);
        int excpected = 2;
        assertEquals(excpected, result);
    }

    @Test
    public void testcalculateDifferenceMonths() {
        System.out.println("calculateDifferenceMonths");
        int result = beginDate.calculateDifferenceMonths(endDate);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void testCalculateDifferenceMonths2() {
        System.out.println("calculateDifferenceMonths2");
        int result = beginDate1.calculateDifferenceMonths(endDate2);
        int expected = 133;
        assertEquals(expected, result);
    }

    @Test
    public void datesMonth() {
        String[] result = beginDate.datesMonth(endDate);
        String[] expected = {"June 2021"};
        assertEquals(expected, result);
    }

    @Test
    public void testPlusDay() {
        System.out.println("plusDay");
        Date d = new Date(2000, 6, 2);
        d.plusDay(50);
        int expected = 22;
        int result = d.getDay();
        assertEquals(expected, result);
    }

    @Test
    public void testPlusMonth() {
        System.out.println("plusMonth");
        Date d = new Date(2000, 6, 2);
        d.plusMonth(6);
        int expected = 12;
        int result = d.getMonth();
        assertEquals(expected, result);
    }

    @Test
    public void testPlusYear() {
        System.out.println("plusYear");
        Date d = new Date(2000, 6, 2);
        d.plusYear(21);
        int expected = 2021;
        int result = d.getYear();
        assertEquals(expected, result);
    }

    @Test
    public void testSetDay() {
        System.out.println("setDay");
        Date d = new Date(2000, 6, 2);
        d.setDay(50);
        int expected = 20;
        int result = d.getDay();
        assertEquals(expected, result);
    }

    @Test
    public void testSetMonth() {
        System.out.println("setMonth");
        Date d = new Date(2000, 6, 2);
        d.setMonth(13);
        int expected = 1;
        int result = d.getMonth();
        assertEquals(expected, result);
    }

    @Test
    public void testSetYear() {
        System.out.println("setYear");
        Date d = new Date(2000, 6, 2);
        d.setYear(21);
        int expected = 21;
        int result = d.getYear();
        assertEquals(expected, result);
    }

    @Test
    public void testSetWeek() {
        System.out.println("setWeek");
        Date d = new Date(2000, 6, 29);
        d.plusDay(7);
        int expected = 6;
        int result = d.getDay();
        assertEquals(expected, result);
    }
}
