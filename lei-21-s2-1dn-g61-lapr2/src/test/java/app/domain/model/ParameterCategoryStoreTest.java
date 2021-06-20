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
public class ParameterCategoryStoreTest {
    
    public ParameterCategoryStoreTest() {
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
     * Test of createParameterCategory method, of class ParameterCategoryStore.
     */
    @Test
    public void testCreateParameterCategory() {
        System.out.println("createParameterCategory");
        String code = "123456";
        String description = "This is a parameter category";
        String nhsId = "1234";
        
        List<ParameterCategory> list=null;        
        ParameterCategoryStore instance = new ParameterCategoryStore(list);    
        ParameterCategory pc = new ParameterCategory("123456", "This is a parameter category", "1234");
        ParameterCategory result = instance.createParameterCategory(code, description, nhsId);

        assertEquals(0, result.toString().compareTo(pc.toString()));
    }

    /**
     * Test of validateParameterCategory method, of class ParameterCategoryStore, pc is null
     */
    @Test
    public void testValidateParameterCategory1() {
        System.out.println("validateParameterCategory");
     
        List<ParameterCategory> list=null;        
        ParameterCategoryStore instance = new ParameterCategoryStore(list);
        
        ParameterCategory pc = null;
        
        assertFalse(instance.validateParameterCategory(pc));
    }
    
    /**
     * Test of validateParameterCategory method, of class ParameterCategoryStore, pc is not valid
     */
    @Test
    public void testValidateParameterCategory2() {
        System.out.println("validateParameterCategory");
     
        List<ParameterCategory> list= new ArrayList<>(); 
        ParameterCategoryStore instance = new ParameterCategoryStore(list);
    
        ParameterCategory pc = new ParameterCategory("123456", "This is a parameter category", "1234");
        list.add(pc);
        
        assertFalse(instance.validateParameterCategory(pc));
    }
    
    /**
     * Test of validateParameterCategory method, of class ParameterCategoryStore, pc is valid
     */
    @Test
    public void testValidateParameterCategory3() {
        System.out.println("validateParameterCategory");
     
        List<ParameterCategory> list= new ArrayList<>(); 
        ParameterCategoryStore instance = new ParameterCategoryStore(list);
    
        ParameterCategory pc = new ParameterCategory("123456", "This is a parameter category", "1234");
        
        assertTrue(instance.validateParameterCategory(pc));
    }

    /**
     * Test of saveParameterCategory method, of class ParameterCategoryStore, pc is valid
     */
    @Test
    public void testSaveParameterCategory1() {
        System.out.println("saveParameterCategory");
        
        List<ParameterCategory> list= new ArrayList<>(); 
        ParameterCategoryStore instance = new ParameterCategoryStore(list);
    
        ParameterCategory pc = new ParameterCategory("123456", "This is a parameter category", "1234");
        
        assertTrue(instance.saveParameterCategory(pc));
    }
    
    /**
     * Test of saveParameterCategory method, of class ParameterCategoryStore, pc is valid
     */
    @Test
    public void testSaveParameterCategory2() {
        System.out.println("saveParameterCategory");
        
        List<ParameterCategory> list= new ArrayList<>(); 
        ParameterCategoryStore instance = new ParameterCategoryStore(list);
    
        ParameterCategory pc = new ParameterCategory("123456", "This is a parameter category", "1234");
        list.add(pc);
        
        assertFalse(instance.saveParameterCategory(pc));
    }
    
    /**
     * Test of getParameterCategoryList method, of class TestTypeStore
     */
    @Test
    public void testParameterCategoryList(){
        System.out.println("getParameterCategoryList");
       
        List<ParameterCategory> list= new ArrayList<>();
        ParameterCategoryStore instance = new ParameterCategoryStore(list);
        
        ParameterCategory pc = new ParameterCategory("pc004", "description", "1234");
        list.add(pc);
        
        assertEquals(instance.getParameterCategories(), list);      
    }
    
}
