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
public class TestTypeTest {
    
    public TestTypeTest() {
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
     * Test of setDescription method, of class TestType.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "54321";
        TestType instance = new TestType("12345", "description", "Blood, Saliva");
        instance.setCode(code);
        assertEquals("54321", instance.getCode());
    }
    /**
     * Test of setDescription method, of class TestType.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "description2";
        TestType instance = new TestType("12345", "description", "Blood, Saliva");
        instance.setDescription(description);
        assertEquals("description2", instance.getDescription());
    }
    /**
     * Test of setMethods method, of class TestType.
     */
    @Test
    public void testSetMethods() {
        System.out.println("setMethods");
        String methods = "Blood, Urine";
        TestType instance = new TestType("12345", "description", "Blood, Saliva");
        instance.setMethods(methods);
        assertEquals("Blood, Urine", instance.getMethods());
    }

    
    /**
     * Test of getCode method, of class TestType.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        TestType instance = new TestType("12345", "description", "Blood, Saliva");
        String expResult = "12345";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }
    /**
     * Test of getDescription method, of class TestType.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        TestType instance = new TestType("12345", "description", "Blood, Saliva");
        String expResult = "description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
    /**
     * Test of getMethods method, of class TestType.
     */
    @Test
    public void testGetMethods() {
        System.out.println("getMethods");
        TestType instance = new TestType("12345", "description", "Blood, Saliva");
        String expResult = "Blood, Saliva";
        String result = instance.getMethods();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of toString method, of class TestType.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TestType instance = new TestType("12345", "description", "Blood, Saliva");
        String expResult = "Test Type #12345\n"
                + "Description: description\n"
                + "Collecting methods: Blood, Saliva";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Mutation Test of checkCodeRules method, of class TestType, description chars==5
     */
    @Test
    public void testCheckCodeRules1() {  
        try{
            TestType instance = new TestType("12345", "description", "Blood, Saliva");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Test of checkCodeRules method, of class TestType, description chars!=5
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules2() {  
        TestType instance = new TestType("123", "description", "Blood, Saliva");    
    }
    /**
     * Test of checkCodeRules method, of class TestType, description chars not alphanumeric
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules4() {  
        TestType instance = new TestType("     ", "description", "Blood, Saliva");
    }
    
    
    /**
     * Mutation Test of checkDescriptionRules method, of class TestType, description chars<=1
     */
    @Test
    public void testCheckDescriptionRules1() {  
        try{
            TestType instance = new TestType("12345", "s", "Blood, Saliva");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkDescriptionRules method, of class TestType, description chars>=15
     */
    @Test
    public void testCheckDescriptionRules2() {
        try{
            TestType instance = new TestType("12345", "123451234512345", "Blood, Saliva");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }  
    /**
     * Test of checkDescriptionRules method, of class TestType, description chars<1
     */  
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules3() {
        TestType instance = new TestType("12345", "", "Blood, Saliva");
    }
    
    /**
     * Test of checkDescriptionRules method, of class TestType, description chars>15
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules4() {
        TestType instance = new TestType("12345", "12345123451234512345123451234512345123459999", "Blood, Saliva"); 
    }
    /**
     * Test of checkDescriptionRules method, of class TestType, description chars not alphanumeric
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules5() {
        TestType instance = new TestType("12345", "     ", "Blood, Saliva"); 
    }
 
    
    /**
     * Test of checkCollectingMethods method, of class TestType, collectingMethods chars=0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCollectingMethodsRules1() {
    TestType instance = new TestType("12345", "description", "");
    }
    /**
     * Test of checkCollectingMethods method, of class TestType, collectingMethods chars>20
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCollectingMethodsRules2() {
    TestType instance = new TestType("12345", "description", "1234512345123451234512345123451234512345");
    }
    
    /**
     * Mutation Test of checkCollectingMethods method, of class TestType, collectingMethods chars<=1
     */
    @Test
    public void testCheckCollectingMethodsRules3() {
        try{
            TestType instance = new TestType("12345", "description", "1");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    
    }
    
    /**
     * Mutation Test of checkCollectingMethods method, of class TestType, collectingMethods chars>=20
     */
    @Test
    public void testCheckCollectingMethodsRules4() {
        try{
            TestType instance = new TestType("12345", "description", "12345123451234512345");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    
    }
    
    /**
     * Coverage Test of checkCollectingMethods method, of class TestType, collectingMethods is empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCollectingMethodsRules5() {

        TestType instance = new TestType("12345", "description", "     ");
    }
    
    /**
     * Coverage Test of void checkCollectingMethods method during the creation of new objects
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTestType() {
    TestType instance = new TestType("12345", "", "Blood, Saliva");
    }
    
 
    /**
     * Mutation Test of setDescription method, of class TestType, collectingMethods chars=0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetCode2() {
        TestType instance = new TestType("12345", "description", "Blood, Saliva");
        instance.setCode("123");
    }
    /**
     * Mutation Test of setDescription method, of class TestType, collectingMethods chars=0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescription2() {
    TestType instance = new TestType("12345", "a", "Blood, Saliva");
    instance.setDescription("");
    }
    /**
     * Mutation Test of setDescription method, of class TestType, collectingMethods chars=0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMethods2() {
        TestType instance = new TestType("12345", "a", "Blood, Saliva");
        instance.setMethods("");
    }
    
    /**
     * Test for testAddTestTypeParameter method, of class TestType
     */
    @Test
    public void testAddTestTypeParameter(){
        TestType instance = new TestType("12345", "a", "Blood, Saliva");
        ParameterCategory pc = new ParameterCategory("1234", "description", "1234");

        instance.addTestTypeCategory(pc);
        ParameterCategory pp = instance.getCategories().get(0);
        
        assertEquals(pc, pp);
    }
   
}
