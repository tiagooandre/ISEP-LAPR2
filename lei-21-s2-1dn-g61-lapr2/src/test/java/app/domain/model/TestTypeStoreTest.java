/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class TestTypeStoreTest {
    
    public TestTypeStoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createTestType method, of class TestTypeStore.
     */
    @Test
    public void testCreateTestType() {
        System.out.println("createTestType");
        String code="12345";
        String description = "description";
        String collectingMethods = "Blood, Saliva";
        
        List<TestType> list=null;        
        TestTypeStore instance = new TestTypeStore(list);    
        TestType tt = new TestType("12345", "description", "Blood, Saliva");
        TestType result = instance.createTestType(code, description, collectingMethods);

        assertEquals(0, result.toString().compareTo(tt.toString()));
    }

    /**
     * Test of validateTestType method, of class TestTypeStore, pc is null
     */
    @Test
    public void testValidateTestType1() {
        System.out.println("validateTestType");
        
        List<TestType> list=null;        
        TestTypeStore instance = new TestTypeStore(list);
        
        TestType tt = null;
               
        assertFalse(instance.validateTestType(tt));
    }
    /**
     * Test of validateTestType method, of class TestTypeStore, pc is not valid
     */
    @Test
    public void testValidateTestType2() {
        System.out.println("validateTestType");
        
        List<TestType> list=new ArrayList<>();        
        TestTypeStore instance = new TestTypeStore(list);
        
        TestType tt = new TestType("12345", "description", "Blood, Saliva");
        list.add(tt);
        
        assertFalse(instance.validateTestType(tt));
    }
    
    /**
     * Test of validateTestType method, of class TestTypeStore, pc is valid
     */
    @Test
    public void testValidateTestType3() {
        System.out.println("validateTestType");
        
        List<TestType> list=new ArrayList<>();        
        TestTypeStore instance = new TestTypeStore(list);
        
        TestType tt = new TestType("12345", "description", "Blood, Saliva");
        
        assertTrue(instance.validateTestType(tt));
    }

    /**
     * Test of saveTestType method, of class TestTypeStore, tt is valid
     */
    @Test
    public void testSaveTestType1() {
        System.out.println("saveTestType");
       
        List<TestType> list= new ArrayList<>(); 
        TestTypeStore instance = new TestTypeStore(list);
    
        TestType tt = new TestType("12345", "description", "Blood, Saliva");
        
        assertTrue(instance.saveTestType(tt));
    }
    
    /**
     * Test of saveTestType method, of class TestTypeStore, tt is not valid
     */
    @Test
    public void testSaveTestType2() {
        System.out.println("saveTestType");
       
        List<TestType> list= new ArrayList<>(); 
        TestTypeStore instance = new TestTypeStore(list);
    
        TestType tt = new TestType("12345", "description", "Blood, Saliva");
        list.add(tt);
        
        assertFalse(instance.saveTestType(tt));
    }
    
    /**
     * Test of getTestTypes method, of class TestTypeStore
     */
    @Test
    public void testGetTestTypes(){
        System.out.println("getTestTypes");
       
        List<TestType> list= new ArrayList<>();
        TestTypeStore instance = new TestTypeStore(list);
        
        TestType tt = new TestType("tt003", "UrineTest", "Urine");
        list.add(tt);
        assertEquals(instance.getTestTypes(), list);      
    }
    
    /**
     * Test of getTestTypeById method, of class TestTypeStore
     */
    @Test
    public void testGetTestTypeById1(){
        System.out.println("getTestTypeById1");
        TestType instance = new TestType("tt001", "CovidTest", "Swab");
        
        List<TestType> list= new ArrayList<>();
        list.add(instance);
        
        TestTypeStore tts = new TestTypeStore(list);
        
        String expected = instance.toString();
        String result = tts.getTestTypeById("tt001").toString();
        
        assertEquals(expected, result);
    }
    
    /**
     * Test of getTestTypeById method, of class TestTypeStore
     */
    @Test
    public void testGetTestTypeById2(){
        System.out.println("getTestTypeById2");
        TestType instance = new TestType("tt001", "CovidTest", "Swab");
        
        List<TestType> list= new ArrayList<>();
        list.add(instance);
        
        TestTypeStore tts = new TestTypeStore(list);

        TestType result = tts.getTestTypeById("tt003");
        
        assertEquals(null, result);
    }

}
