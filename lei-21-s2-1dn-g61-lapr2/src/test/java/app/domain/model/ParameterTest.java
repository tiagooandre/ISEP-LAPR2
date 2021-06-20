/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

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
public class ParameterTest {
    
    public ParameterTest() {
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
     * Test of setCode method, of class Parameter.
     */
    @Test
    public void testSetCode_PC() {
        System.out.println("setCode");
        String code = "54321";
        ParameterCategory pc = new ParameterCategory("12345", "this is a description", "12345");
        Parameter instance = new Parameter(code,"ddddd",pc);
        instance.setCodeP(code);
        assertEquals("54321", instance.getCodeP());
    }

    /**
     * Test of setDescription_P method, of class Parameter.
     */
    @Test
    public void testSetDescription_P() {
        System.out.println("setDescription_P");
        String description = "this is a parameter description";
         ParameterCategory pc = new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("1111","this is a parameter description",pc);
        instance.setDescriptionP(description);
         assertEquals(instance.getDescriptionP(), description);
    }

    /**
     * Test of getCategory_P method, of class Parameter.
     */
    @Test
    public void testGetCategory_P() {
        System.out.println("getCategory_P");
          ParameterCategory pc = new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("1111","this is a parameter",pc);
      
        ParameterCategory result = instance.getCategoryP();
        assertEquals(pc,result);
      
    }

    /**
     * Test of setCategory_P method, of class Parameter.
     */
    @Test
    public void testSetCategory_P() {
        System.out.println("setCategory_P");
        ParameterCategory category =  new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("3333","this is a parameter",category);
        instance.setCategoryP(category);
        assertEquals(instance.getCategoryP(),category);

    }
    
     /**
     * Test of getCode method, of class Parameter.
     */
    @Test
    public void testGetCode_PC() {
        System.out.println("getCode");
        ParameterCategory pc = new ParameterCategory("12345", "this is a description", "12345");
        Parameter instance = new Parameter("12345","sssss",pc);
        String expResult = "12345";
        String result = instance.getCodeP();
        assertEquals(expResult, result);
    }
  

    /**
     * Test of getDescription_P method, of class Parameter.
     */
    @Test
    public void testGetDescription_P() {
        System.out.println("getDescription_P");
        ParameterCategory category =  new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("3333","this is a parameter",  category);
        String expResult = "this is a parameter";
        String result = instance.getDescriptionP();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of toString method, of class Parameter.
     */
   /* @Test
    public void testToString() {
        System.out.println("toString");
        ParameterCategory category  = new ParameterCategory("1234","this is a parameter category","1234");
        Parameter instance = new Parameter("4444","this is a parameter",category);
        String expResult = "Parameter \n"
                           + "this is a parameter\n"
                           + "Category id: 1234";
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }*/
    
   /**
     * Test of checkCodeRules method, of class Parameter, code chars<4
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules1() {
         ParameterCategory category =  new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("123", "this is a description", category);
    }
    
    /**
     * Test of checkCodeRules method, of class Parameter, code chars>8
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules2() {
         ParameterCategory category =  new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("123456789", "this is a description", category);
    }
    
    /**
     * Mutation Test of checkCodeRules method, of class Parameter, code chars<=4
     */
    @Test
    public void testCheckCodeRules3() {
        try{
             ParameterCategory category =  new ParameterCategory("1234","this is a parameter cateogry","1234");
            Parameter instance = new Parameter("1234", "this is a description", category);
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    
    /**
     * Mutation Test of checkCodeRules method, of class Parameter, code chars>=8
     */
    @Test
    public void testCheckCodeRules4() {
        try{
             ParameterCategory category =  new ParameterCategory("1234","this is a parameter cateogry","1234");
            Parameter instance = new Parameter("12345678", "this is a description", category);
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    
    /**
     * Test of checkCodeRules method, of class Parameter, code is blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules5() {
         ParameterCategory category =  new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("     ", "this is a description", category);
    }
    
    /**
     * Mutation Test of checkDescriptionRules method, of class Parameter, description chars<=1
     */
    @Test
    public void testCheckDescriptionRules1() {  
        try{
              ParameterCategory pc = new ParameterCategory("1234","this is a parameter cateogry","1234");
            Parameter instance = new Parameter("1111", "1", pc);
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    
    /**
     * Mutation Test of checkDescriptionRules method, of class Parameter, description chars>=40
     */
    @Test
    public void testCheckDescriptionRules2() {
        try{
              ParameterCategory pc = new ParameterCategory("1234","this is a parameter cateogry","1234");
            Parameter instance = new Parameter("1111", "1234512345123451234512345123451234512345", pc);
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    
    /**
     * Test of checkDescriptionRules method, of class Parameter, description chars<1
     */
    
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules3() {
        ParameterCategory pc = new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("1111", "",  pc);
    }
    
    /**
     * Test of checkDescriptionRules method, of class Parameter, description chars>40
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules4() {
          ParameterCategory pc = new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("4444", "12345123451234512345123451234512345123459999", pc); 
    }
    
     /**
     * Test of checkDescriptionRules method, of class Parameter, description is empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules5() {
        ParameterCategory pc = new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("1111", " ",  pc);
    }
    
    /**
     * Mutation Test of setDescription method, of class Parameter, description chars=0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescription1() {
          ParameterCategory pc = new ParameterCategory("1234","this is a parameter cateogry","1234");
        Parameter instance = new Parameter("5555", "aaaaaaaaaaaaaaa", pc);
        instance.setDescriptionP("");
    }
    
   


}









