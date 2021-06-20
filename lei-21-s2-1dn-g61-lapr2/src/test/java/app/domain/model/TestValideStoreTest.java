package app.domain.model;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestValideStoreTest {

    String nhs = "000000000005";

    @Test
    public void testValidateTest(){
        List<app.domain.model.Test> list = new ArrayList<>();
        TestValideStore store = new TestValideStore(list);
        app.domain.model.Test t1 = null;
        boolean expected = store.addValide(t1);
        assertFalse(expected);
    }
    @Test
    public void testValidateTest1(){
        List<app.domain.model.Test> list = new ArrayList<>();
        TestValideStore store = new TestValideStore(list);
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        t1.setTimeDiagnosis();
        t1.setTimeChemAnalysis();
        t1.setTimeSample();
        t1.setDateChemAnalysis();
        t1.setDateSample();
        t1.setDateDiagnosis();
        t1.setTimeValidTest();
        t1.setDateValidTest();
        list.add(t1);

        boolean expected = store.addValide(t1);
        assertFalse(expected);
    }
    /*@Test
    public void testValidateTest2(){
        List<app.domain.model.Test> list = new ArrayList<>();
        TestValideStore store = new TestValideStore(list);
        String nhs = "000000000005";
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        t1.setTimeDiagnosis();
        t1.setTimeChemAnalysis();
        t1.setTimeSample();
        t1.setDateChemAnalysis();
        t1.setDateSample();
        t1.setDateDiagnosis();
        t1.setTimeValidTest();
        t1.setDateValidTest();


        boolean expected = store.addValide(t1);
        assertTrue(expected);
    }*/
    @Test
    public void testSave(){
        List<app.domain.model.Test> list = new ArrayList<>();
        TestValideStore store = new TestValideStore(list);
        Client c = new Client("andre", "1234567890123456", "23/05/2001","1234567890", "1234567890", "andre@email.com" ,"12345678901");
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        t1.setTimeDiagnosis();
        t1.setTimeChemAnalysis();
        t1.setTimeSample();
        t1.setDateChemAnalysis();
        t1.setDateSample();
        t1.setDateDiagnosis();
        t1.setTimeValidTest();
        t1.setDateValidTest();
        t1.setClient(c);


        boolean expected = store.addValide(t1);
        assertTrue(expected);
    }
    @Test
    public void testSave1(){
        List<app.domain.model.Test> list = new ArrayList<>();
        TestValideStore store = new TestValideStore(list);
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        t1.setTimeDiagnosis();
        t1.setTimeChemAnalysis();
        t1.setTimeSample();
        t1.setDateChemAnalysis();
        t1.setDateSample();
        t1.setDateDiagnosis();
        t1.setTimeValidTest();
        t1.setDateValidTest();
        list.add(t1);

        boolean expected = store.addValide(t1);
        assertFalse(expected);
    }
    @Test
    public void testSave2(){
        List<app.domain.model.Test> list = new ArrayList<>();
        TestValideStore store = new TestValideStore(list);
        app.domain.model.Test t1 = null;

        boolean expected = store.addValide(t1);
        assertFalse(expected);
    }

    @Test
    public void testGetTestsValid(){
        app.domain.model.Test t1 = new app.domain.model.Test("123456789012");
        app.domain.model.Test t2 = new app.domain.model.Test("123456789112");
        List<app.domain.model.Test> testList = new ArrayList<>();
        testList.add(t1);
        testList.add(t2);

        TestValideStore store = new TestValideStore(testList);

        int expected = 2;
        int result = store.getTestsValids().size();

        assertEquals(expected, result);
    }

    @Test
    public void testStringToDouble1(){
        List<app.domain.model.Test> testList = new ArrayList<>();
        TestValideStore store = new TestValideStore(testList);
        String num = "2,4";

        double expected = 2.4;
        double result = store.stringToDouble(num);

        assertEquals(expected, result, 1);
    }
    @Test
    public void testStringToDouble2(){
        List<app.domain.model.Test> testList = new ArrayList<>();
        TestValideStore store = new TestValideStore(testList);
        String num = "2.4";

        double expected = 2.4;
        double result = store.stringToDouble(num);

        assertEquals(expected, result, 1);
    }



}