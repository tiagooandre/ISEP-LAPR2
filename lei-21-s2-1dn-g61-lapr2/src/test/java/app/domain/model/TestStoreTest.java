/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.util.ArrayList;
import java.util.List;

import app.controller.ValidatingWorkController;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan e tiago
 */
public class TestStoreTest {

    /**
     * Test 1: createTestType method, of class TestTypeStore.
     */
    @Test
    public void testCreateTest() {
        System.out.println("createTest");
        String nh="543215432112";
        app.domain.model.Test test = new app.domain.model.Test(nh);

        List<app.domain.model.Test> list=null;
        TestStore instance = new TestStore(list);
        app.domain.model.Test tt = new app.domain.model.Test("543215432112");
        app.domain.model.Test result = instance.createTest(nh);

        assertEquals(0, result.getNHScode().compareTo(tt.getNHScode()));
    }

    /**
     * Test 2: validateTestType method, of class TestTypeStore, t is null
     */
    @Test
    public void testValidateTest1() {
        System.out.println("validateTest");

        List<app.domain.model.Test> list=null;
        TestStore instance = new TestStore(list);

        app.domain.model.Test t = null;

        assertFalse(instance.validateTest(t));
    }

    /**
     * Test 3: validateTestType method, of class TestTypeStore, t is not valid
     */
    @Test
    public void testValidateTestType2() {
        System.out.println("validateTest");

        List<app.domain.model.Test> list=new ArrayList<>();
        TestStore instance = new TestStore(list);

        app.domain.model.Test t = new app.domain.model.Test("123451234512");
        t.setCode("000000000001");

        list.add(t);

        assertFalse(instance.validateTest(t));
    }

    /**
     * Test 4: validateTestType method, of class TestTypeStore, t is valid
     */
    @Test
    public void testValidateTestType3() {
        System.out.println("validateTest");

        List<app.domain.model.Test> list=new ArrayList<>();
        TestStore instance = new TestStore(list);

        app.domain.model.Test t = new app.domain.model.Test("123451234512");

        assertTrue(instance.validateTest(t));
    }

    /**
     * Test 5: saveTest method, of class TestStore, t is valid
     */
    @Test
    public void testSaveTestType1() {
        System.out.println("saveTestType");

        List<app.domain.model.Test> list= new ArrayList<>();
        TestStore instance = new TestStore(list);

        app.domain.model.Test t = new app.domain.model.Test("123451234512");

        assertTrue(instance.saveTest(t));
    }

    /**
     * Test 6: saveTestType method, of class TestTypeStore, t is not valid
     */
    @Test
    public void testSaveTest2() {
        System.out.println("saveTest");

        List<app.domain.model.Test> list= new ArrayList<>();
        TestStore instance = new TestStore(list);

        app.domain.model.Test t = new app.domain.model.Test("123451234512");
        t.setCode("000000000001");
        list.add(t);

        assertFalse(instance.saveTest(t));
    }

    /* *//**
     * Test 7: tExists method, of class TestTypeStore, t is not valid
     *//*
    @Test
    public void testTExists1() {
        System.out.println("tExists");

        List<app.domain.model.Test> list=new ArrayList<>();
        app.domain.model.Test t = new app.domain.model.Test("123451234512");
        list.add(t);

        TestStore instance = new TestStore(list);
        app.domain.model.Test t2 = new app.domain.model.Test("123451234512");

        assertFalse(instance.tExists(list, t2));
    }*/

    /**
     * Test 8: tExists method, of class TestTypeStore, t not valid
     */
    @Test
    public void testTExists2() {
        System.out.println("tExists");

        List<app.domain.model.Test> list=new ArrayList<>();
        app.domain.model.Test t = new app.domain.model.Test("123451234512");
        list.add(t);

        TestStore instance = new TestStore(list);
        app.domain.model.Test t2 = new app.domain.model.Test("123451234588");
        t.setCode("000000000001");
        t2.setCode("000000000002");
        assertTrue(instance.tExists(list, t2));
    }

    /**
     * Test 9: getTests method, of class TestStore
     */
    @Test
    public void testGetTests(){
        System.out.println("getTests");
        String nh="543215432112";
        app.domain.model.Test test = new app.domain.model.Test(nh);

        List<app.domain.model.Test> expected= new ArrayList<>();
        expected.add(test);

        TestStore instance = new TestStore(expected);
        List<app.domain.model.Test> result = instance.getTests();

        assertEquals(expected, result);
    }

    @Test
    public void testGetTestBycode() {
        System.out.println("getTestByCodeTest");
        String nh = "000000000007";
        String nh1 = "000000000008";

        app.domain.model.Test t1 = new app.domain.model.Test(nh);
        app.domain.model.Test t3 = new app.domain.model.Test(nh1);
        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(t1);
        list.add(t3);
        TestStore tt = new TestStore(list);
        String nsh = "000000000005";
        app.domain.model.Test t2 = new app.domain.model.Test(nsh);
        t1.setCode("000000000001");
        t2.setCode("000000000002");
        t2.setCode(t1.getCode());
        String code = t1.getCode();
        app.domain.model.Test t4 = tt.getTestByCode(code);

        assertNotEquals(t2,t4);
    }

    @Test
    public void testGetTestBycode2() {
        System.out.println("getTestByCodeTest2");
        String nh = "000000000007";
        String nh2 = "000000000008";

        app.domain.model.Test t1 = new app.domain.model.Test(nh);
        app.domain.model.Test t2 = new app.domain.model.Test(nh2);
        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        t1.setCode("000000000001");
        t2.setCode("000000000002");

        TestStore tt = new TestStore(list);
        String code = t2.getCode();

        assertNotEquals(t1, tt.getTestByCode(code));
    }

    @Test
    public void testGetTestBycode3() {
        System.out.println("getTestByCodeTest3");
        String nh = "000000000007";

        app.domain.model.Test t1 = new app.domain.model.Test(nh);
        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(t1);

        TestStore tt = new TestStore(list);
        t1.setCode("000000000001");
        String code = t1.getCode();


        assertEquals(t1, tt.getTestByCode(code));
    }

    /**
     * Test of getTestTypeByBarcode method, of class TestStore
     */
    @Test
    public void testGetTestByBarcode() {
        System.out.println("GetTestByBarcode");
        app.domain.model.Test t1 = new app.domain.model.Test("123456789012");
        Sample s = new Sample("123456789012");
        t1.addSample(s);

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(t1);
        TestStore tt = new TestStore(list);

        String expected = t1.toString();

        String result = tt.getTestByBarcode("123456789012").toString();

        assertEquals(expected, result);
    }

    @Test
    public void testGetTestByBarcode2() {
        System.out.println("GetTestByBarcode2");
        app.domain.model.Test t1 = new app.domain.model.Test("123456789012");
        Sample s = new Sample("123456789012");
        t1.addSample(s);

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(t1);
        TestStore tt = new TestStore(list);

        assertNotEquals(t1, tt.getTestByBarcode("123456789010"));
    }

    /**
     * Test of getTestByNHS method, of class TestStore
     */
    @Test
    public void testGetTestByNHS() {
        System.out.println("getTestByNHS");

        app.domain.model.Test t1 = new app.domain.model.Test("123456789012");

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(t1);
        TestStore tt = new TestStore(list);

        assertEquals(t1, tt.getTestByNHS("123456789012"));
    }

    @Test
    public void testGetTestByNHS2() {
        System.out.println("getTestByNHS2");

        app.domain.model.Test t1 = new app.domain.model.Test("123456789012");

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(t1);
        TestStore tt = new TestStore(list);

        assertNotEquals(t1, tt.getTestByNHS("123456789011"));
    }

    /**
     * Test of generateCode method, of class TestStore
     */
    @Test
    public void testGenerateCode() {
        System.out.println("generateCode");

        app.domain.model.Test t1 = new app.domain.model.Test("123456789012");

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(t1);
        TestStore tt = new TestStore(list);

        String expRes = "000000000002";
        String res = tt.generateCode().toString();

        assertEquals(expRes, res);
    }
}