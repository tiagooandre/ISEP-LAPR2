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
 * @author Goncalo
 */
public class ParameterStoreTest {
    
    public ParameterStoreTest() {
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
     * Test of createParameter method, of class ParameterStore.
     */
    @Test
    public void testCreateParameter() {
        System.out.println("createParameter");
        String code = "123456";
        String description = "This is a parameter";
        app.domain.model.ParameterCategory category = new ParameterCategory(code,description,"1234");
        
        List<Parameter> list = null;
        ParameterStore instance = new ParameterStore(list);
        Parameter result = instance.createParameter( code,description, category);
        Parameter p = new Parameter(code,description,category);

        assertEquals(0, result.toString().compareTo(p.toString()));
    }

    /**
     * Test of validateParameter method, of class ParameterStore, p is null.
     */
    @Test
    public void testValidateParameter() {
        System.out.println("validateParameter");
        Parameter p = null;
        
        List<Parameter> list = null;
        ParameterStore instance = new ParameterStore(list);
     
        assertFalse(instance.validateParameter(p));
    }
    
    /**
     * Test of validateParameter method, of class ParameterStore, p is not valid.
     */
       @Test
    public void testValidateParameter2() {
        System.out.println("validateParameter");
        Parameter p = new Parameter("1111","This is a parameter",new ParameterCategory("123456","This is a parameter category","1234")) ;
        
        List<Parameter> list = new ArrayList<>();
        ParameterStore instance = new ParameterStore(list);
     
        list.add(p);
        assertFalse(instance.validateParameter(p));
    }
    
     /**
     * Test of validateParameter method, of class ParameterStore, p is valid.
     */
       @Test
    public void testValidateParameter3() {
        System.out.println("validateParameter");
        Parameter p = new Parameter("2222","This is a parameter",new ParameterCategory("111111","This is a parameter category","1234")) ;
        
        List<Parameter> list = new ArrayList<>();
        ParameterStore instance = new ParameterStore(list);
     
       
        assertTrue(instance.validateParameter(p));
    }
    
    /**
     * Test of saveParameter method, of class ParameterStore, pc is valid 
     */
    @Test
    public void testSaveParameter1() {
        System.out.println("saveParameter");
        
        List<Parameter> list = new ArrayList<>();
        Parameter p = new Parameter("3333","This is a parameter",new ParameterCategory("123456","this is a parameter category","1234"));
        
        ParameterStore instance = new ParameterStore(list);
      
        assertTrue(instance.saveParameter(p));
        
       
    }
    
      /**
     * Test of saveParameter method, of class ParameterStore, pc is not valid 
     */
    @Test
    public void testSaveParameter2() {
        System.out.println("saveParameter");
        
        List<Parameter> list = new ArrayList<>();
        Parameter p = new Parameter("4444","This is a parameter",new ParameterCategory("123456","this is a parameter category","1234"));
        
        ParameterStore instance = new ParameterStore(list);
        list.add(p);
        
        assertFalse(instance.saveParameter(p));
        
       
    }
    
     /**
     * Test of saveParameter method, of class ParameterStore, pc is null 
     */
    @Test
    public void testSaveParameter3() {
        System.out.println("saveParameter");
        
        List<Parameter> list = null;
        Parameter p = null;
        
        ParameterStore instance = new ParameterStore(list);
       
        assertFalse(instance.saveParameter(p));  
    }
    
     /**
     * Test of getParameterList method, of class ParameterStore
     */
    @Test
    public void testGetParameters(){
        System.out.println("getParameterList");
       
        List<Parameter> list= new ArrayList<>();
        ParameterStore instance = new ParameterStore(list);
        
       ParameterCategory pc = new ParameterCategory("pc004", "description", "1234");
        
        Parameter p = new Parameter("pc004", "description", pc);
        list.add(p);
        
        assertEquals(instance.getParameters(), list);      
    }
    
     /**
     * Test of getParameterByCodet method, of class ParameterStore
     */
    @Test
    public void testGetParameterByCode1(){
        List<Parameter> list= new ArrayList<>();
        ParameterStore instance = new ParameterStore(list);
        
        ParameterCategory pc = new ParameterCategory("pc004", "description", "1234");
        Parameter expected = new Parameter("p0006", "ddd", pc);
        list.add(expected);
        Parameter result = instance.getParameterByCode("p0006");
        
        assertEquals(expected, result);
    }
    
     /**
     * Test of getParameterByCode method, of class ParameterStore
     */
    @Test
    public void testGetParameterByCode2(){
        List<Parameter> list= new ArrayList<>();
        ParameterStore instance = new ParameterStore(list);
        
        ParameterCategory pc = new ParameterCategory("pc004", "description", "1234");
        Parameter expected = new Parameter("p0006", "ddd", pc);
        list.add(expected);
        Parameter result = instance.getParameterByCode("p0096");
        
        assertEquals(null, result);
    }
    
}
