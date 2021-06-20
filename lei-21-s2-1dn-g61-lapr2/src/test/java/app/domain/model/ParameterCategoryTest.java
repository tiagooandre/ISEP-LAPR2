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
 * @author renan
 */
public class ParameterCategoryTest {
    
    public ParameterCategoryTest() {
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
     * Test of setCode method, of class ParameterCategory.
     */
    @Test
    public void testSetCode_PC() {
        System.out.println("setCode");
        String code = "54321";
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "12345");
        instance.setCodePC(code);
        assertEquals("54321", instance.getCodePC());
    }

    /**
     * Test of setDescription method, of class ParameterCategory.
     */
    @Test
    public void testSetDescription_PC() {
        System.out.println("setDescription");
        String description = "this is a test description";
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "12345");
        instance.setDescriptionPC(description);
        assertEquals("this is a test description", instance.getDescriptionPC());
    }

    /**
     * Test of setNHS method, of class ParameterCategory.
     */
    @Test
    public void testSetNHS_PC() {
        System.out.println("setNHS");
        String id = "43215";
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "12345");
        instance.setNHSPC(id);
        assertEquals("43215", instance.getNHSPC());
    }

    /**
     * Test of getCode method, of class ParameterCategory.
     */
    @Test
    public void testGetCode_PC() {
        System.out.println("getCode");
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "12345");
        String expResult = "12345";
        String result = instance.getCodePC();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class ParameterCategory.
     */
    @Test
    public void testGetDescription_PC() {
        System.out.println("getDescription");
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "12345");
        String expResult = "this is a description";
        String result = instance.getDescriptionPC();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNHS method, of class ParameterCategory.
     */
    @Test
    public void testGetNHS_PC() {
        System.out.println("getNHS");
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "12345");
        String expResult = "12345";
        String result = instance.getNHSPC();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ParameterCategory.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "12345");
        String expResult = "Parameter Category #12345\n"
                           + "this is a description\n"
                           + "NHS id:12345";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkCodeRules method, of class ParameterCategory, code chars<4
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules1() {
        ParameterCategory instance = new ParameterCategory("123", "this is a description", "12345");
    }
    /**
     * Test of checkCodeRules method, of class ParameterCategory, code chars>8
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules2() {
        ParameterCategory instance = new ParameterCategory("123456789", "this is a description", "12345");
    }
    /**
     * Mutation Test of checkCodeRules method, of class ParameterCategory, code chars<=4
     */
    @Test
    public void testCheckCodeRules3() {
        try{
            ParameterCategory instance = new ParameterCategory("1234", "this is a description", "12345");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkCodeRules method, of class ParameterCategory, code chars>=8
     */
    @Test
    public void testCheckCodeRules4() {
        try{
            ParameterCategory instance = new ParameterCategory("12345678", "this is a description", "12345");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Test of checkCodeRules method, of class ParameterCategory, code is blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules5() {
        ParameterCategory instance = new ParameterCategory("     ", "this is a description", "12345");
    }
    
    /**
     * Mutation Test of checkDescriptionRules method, of class ParameterCategory, description chars<=1
     */
    @Test
    public void testCheckDescriptionRules1() {  
        try{
            ParameterCategory instance = new ParameterCategory("123456", "1", "12345");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkDescriptionRules method, of class ParameterCategory, description chars>=40
     */
    @Test
    public void testCheckDescriptionRules2() {
        try{
            ParameterCategory instance = new ParameterCategory("123456", "1234512345123451234512345123451234512345", "12345");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    
    /**
     * Test of checkDescriptionRules method, of class ParameterCategory, description chars<1
     */
    
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules3() {
        ParameterCategory instance = new ParameterCategory("123456", "", "12345");
    }
    
    /**
     * Test of checkDescriptionRules method, of class ParameterCategory, description chars>40
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules4() {
        ParameterCategory instance = new ParameterCategory("123456", "12345123451234512345123451234512345123459999", "12345"); 
    }
    /**
     * Test of checkDescriptionRules method, of class ParameterCategory, description is blank
     */
    
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules5() {
        ParameterCategory instance = new ParameterCategory("123456", "   ", "12345"); 
    }
    
    /**
     * Mutation Test of setDescription method, of class ParameterCategory, description chars=0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescription1() {
        ParameterCategory instance = new ParameterCategory("123456", "aaaaaaaaaaaaaaa", "12345");
        instance.setDescriptionPC("");
    }
    
    /**
     * Test of checkNHSRules method, of class ParameterCategory, NHS id chars<4
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNHSRules1() {
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "123");
    }
    /**
     * Test of checkNHSRules method, of class ParameterCategory, NHS id chars>8
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNHSRules2() {
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "123456789");
    }
    /**
     * Mutation Test of checkNHSRules method, of class ParameterCategory, NHS id chars<=4
     */
    @Test
    public void testCheckNHSRules3() {
        try{
            ParameterCategory instance = new ParameterCategory("12345", "this is a description", "1234");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkNHSRules method, of class ParameterCategory, NHS id chars>=8
     */
    @Test
    public void testCheckNHSRules4() {
        try{
            ParameterCategory instance = new ParameterCategory("12345", "this is a description", "12345678");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Test of checkNHSRules method, of class ParameterCategory, NHS id is blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNHSRules5() {
        ParameterCategory instance = new ParameterCategory("12345", "this is a description", "    ");
    }
    
    /**
     * Test of setDescription method, of class ParameterCategory, code chars=0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetCode1() {
        ParameterCategory instance = new ParameterCategory("123456", "aaaaaaaaaaaaaaaa", "12345");
        instance.setCodePC("");
    }
    
    /**
     * Test of setNHS method, of class ParameterCategory, code chars=0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetNHS1() {
        ParameterCategory instance = new ParameterCategory("123456", "aaaaaaaaaaaaaaaa", "12345");
        instance.setNHSPC("");
    }
    
    /**
     * Test for getParameters and addTestTypeParameter
     */
    @Test
    public void testAddTestTypeParameter(){
        ParameterCategory instance = new ParameterCategory("1234", "description", "12345");
        ParameterCategory other = new ParameterCategory("4321", "description", "43210");
        
        Parameter p1 = new Parameter("1111" ,"description", instance);
        Parameter p2 = new Parameter("1111", "description", other);
        
        instance.addPCParameter(p1);
        instance.addPCParameter(p2);
        Parameter pp = instance.getParameters().get(1);
        
        assertEquals(p2, pp);
    }

}
