package app.domain.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel Chen 1190897
 */

public class ClinicalAnalysisLaboratoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    //SET TEST
    /**
     * Test of setLabID method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetLabID() {
        System.out.println("setLabID");
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        c.setLaboratoryID("la123");
        assertEquals("la123", c.getLaboratoryID());
    }
    /**
     * Test of setName method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        c.setName("Lab");
        assertEquals("Lab", c.getName());
    }
    /**
     * Test of setAddress method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        c.setAdress("Rua 1");
        assertEquals( "Rua 1", c.getAdress());
    }
    /**
     * Test of setPhone method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhoneNumber");
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "1234567890");
        c.setPhoneNumber("12345678901");
        assertEquals("12345678901", c.getPhoneNumber());
    }
    /**
     * Test of setNumberTIN method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetNumberTIN() {
        System.out.println("setName");
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "1234567890");
        c.setNumberTIN("1234567890");
        assertEquals( "1234567890", c.getNumberTIN());
    }
    // PHONE NUMBER TEST
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber char(digits)!=11 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumberRules1() {
            ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "1234567890", "1234567890");
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber char(digits)!=11 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumber2() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901111", "1234567890");
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber chars(digits)!=11 and contains non digits char
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumber3() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901111b", "1234567890");
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber chars(digits)!=11 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumber4() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "", "1234567890");
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber chars(digits)!=11 and contains non digits char
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumber5() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12b", "1234567890");
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber chars(digits)==11 and dont contains non digits char
     */
    @Test
    public void testCheckPhoneNumber6() {
        try{
            ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "1234567890");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber char(digits)==11 contains blank space
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumberRules7() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345 78901", "1234567890");
    }
    // TIN TEST
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)!=10 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTINRules1() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "");
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)!=10 and dont contain non digits
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTIN2() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "12345678901");
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)!=10 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTIN3() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "123456789");
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)==10 and dont contain non digits
     */
    @Test
    public void testCheckNumberTIN4R() {
        try{
            ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "1234567890");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)!=10 and contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTINRules5() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "a12");
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)!=10 and contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTINRules6() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "asd1llk2345678901");
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)==10 and blank space
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTINRules7() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "12345 7890");
    }
    // NAME TEST
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars>1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNameRules1() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "", "Rua 1", "12345678901", "1234567890");
    }
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars<20
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckName2() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lablololllllllllllllll645675475", "Rua 1", "12345678901", "1234567890");
    }
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars=>1
     */
    @Test
    public void testCheckName3() {
        try{
            ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "l", "R", "12345678901", "1234567890");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars>=20
     */
    @Test
    public void testCheckName4() {
        try{
            ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "12345678901234567890", "12345678901234567890", "12345678901", "1234567890");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    // ADRESS TEST
    /**
     * Mutation Test of checkAddressRules method, of class ClinicalAnalysisLaboratory , Address chars=>1
     */
    @Test
    public void testCheckAddress1() {
        try{
            ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "R", "12345678901", "1234567890");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkAddressRules method, of class ClinicalAnalysisLaboratory , Address chars>1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckAdress2() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab1234567890123456", "", "12345678901", "1234567890");
    }
    /**
     * Mutation Test of checkAddressRules method, of class ClinicalAnalysisLaboratory , Address chars<30
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckAdress3() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab1234567890123456", "Rua21321432432423432423432423423423654654645", "12345678901", "1234567890");
    }
    /**
     * Mutation Test of checkAddressRules method, of class ClinicalAnalysisLaboratory , Address chars==30
     */
    @Test
    public void testAddress4() {
        try{
            ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "123456789012345678901234567890", "12345678901", "1234567890");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    //LABID TEST
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars!=5
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckLabIDRules1() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("", "Lab", "Rua 1", "12345678901", "1234567890");
    }
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars!=5
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckLabID2() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345435", "LAB", "Rua 1", "12345678901", "1234567890");
    }
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars!=5
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckLabID3() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("1235", "Lab", "Rua 1", "12345678901", "1234567890");
    }
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars==5 and contains blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckLabID4() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12 35", "Lab", "Rua 1", "12345678901", "1234567890");
    }
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars==5
     */
    @Test
    public void testCheckLabID5() {
        try{
            ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "1234567890");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    // TEST TOSTRING
    /**
     * Test of toString method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "lab", "Rua 1", "12345678901", "1234567890");
        String exp = "ClinicalAnalysisLaboratory{" +
                "laboratoryID='" + "12345" + '\'' +
                ", name='" + "lab" + '\'' +
                ", adress='" + "Rua 1" + '\'' +
                ", phoneNumber=" + "12345678901" +
                ", numberTIN=" + "1234567890" +
                '}';
        String actual = c.toString();
        assertEquals(exp, actual);
    }
    @Test
    public void testAddClinicalTestType(){
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("la123","na","rua 1","12345678901","1234567890");
        ClinicalAnalysisLaboratory cl1 = new ClinicalAnalysisLaboratory("la234","no","rua 2","12345678901","1234567890");

        TestType t = new TestType("12345","12","12");
        TestType t1 = new TestType("23456","13","13");

        cl.addTestType(t);
        cl.addTestType(t1);
        TestType t11 = cl.getTypeTests().get(1);

        assertEquals(t1, t11);
    }


}




