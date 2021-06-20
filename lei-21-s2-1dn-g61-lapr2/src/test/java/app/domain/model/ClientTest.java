package app.domain.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientTest {

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
    public void testSetNHSID() {
        System.out.println("setNHSID");
        Client cl = new Client("Joana", "1234567890123456", "8/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        cl.setNhsid("1234567809");
        assertEquals("1234567809", cl.getNhsid());
    }

    /**
     * Test of setName method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        Client cl = new Client("Joana", "1234567890123456", "18/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        cl.setName("Lab");
        assertEquals("Lab", cl.getName());
    }

    /**
     * Test of setAddress method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetBirth() {
        System.out.println("setBirth");
        Client cl = new Client("Joana", "1234567890123456", "18/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        cl.setBirth("10/10/1900");
        assertEquals("10/10/1900", cl.getBirth());
    }

    /**
     * Test of setPhone method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhoneNumber");
        Client cl = new Client("Joana", "1234567890123456", "18/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        cl.setPhonenumber("12345678901");
        assertEquals("12345678901", cl.getPhonenumber());
    }

    /**
     * Test of setNumberTIN method, of class ClinicalAnalysisLaboratory.
     */
    @Test
    public void testSetNumberTIN() {
        System.out.println("setTIN");
        Client cl = new Client("Joana", "1234567890123456", "18/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        cl.setTin("1234567890");
        assertEquals("1234567890", cl.getTin());
    }

    @Test
    public void testSetCC() {
        System.out.println("setcc");
        Client cl = new Client("Joana", "1234567890123456", "18/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        cl.setCc("0987654321098765");
        assertEquals("0987654321098765", cl.getCc());
    }
    @Test
    public void testSetSex() {
        System.out.println("setSex");
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        cl.setSex("Male");
        assertEquals("Male", cl.getSex());
    }
    // PHONE NUMBER TEST
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber char(digits)!=11 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumberRules1() {
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","","Female");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumberRules4() {
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","a12","Female");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumberRules5() {
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","a122324434235353453","Female");
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber char(digits)!=11 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumber2() {
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","123 5678901","Female");
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber chars(digits)!=11 and contains non digits char
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumber3() {
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","1234567890","Female");
    }
    /**
     * Mutation Test of checkPhoneNumberRules method, of class ClinicalAnalysisLaboratory , PhoneNumber chars(digits)==11 and dont contains non digits char
     */
    @Test
    public void testCheckPhoneNumber6() {
        try{
            Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPhoneNumber7() {
        Client cl = new Client("Joana","1234567890123456","18/05/3001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901111","Female");
    }
    // TIN TEST
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)!=10 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTINRules1() {
        Client cl = new Client("Joana","1234567890123456","18/05/3301","1234567890","","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)!=10 and dont contain non digits
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTIN2() {
        Client cl = new Client("Joana","1234567890123456","18/05/2201","1234567890","1234 67890","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)!=10 and dont contain non digits
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNumberTIN3() {
        Client cl = new Client("Joana","1234567890123456","18/05/2201","1234567890","12345678A0","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkNumberTINRules method, of class ClinicalAnalysisLaboratory , TIN chars(digits)==10 and dont contain non digits
     */
    @Test
    public void testCheckNumberTIN4R() {
        try{
            Client cl = new Client("Joana","1234567890123456","18/05/1991","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    // NAME TEST
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars>1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNameRules1() {
        Client cl = new Client("","1234567890123456","18/05/2201","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars<20
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckName2() {
        Client cl = new Client("1234567890123456789012345678901234567","1234567890123456","18/05/2201","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars=>1
     */
    @Test
    public void testCheckName3() {
        try{
            Client cl = new Client("J","1234567890123456","18/05/20001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
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
            Client cl = new Client("12345678901234567890123456789012345","1234567890123456","18/05/20001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    // NHSID TEST
    /**
     * Mutation Test of checkAddressRules method, of class ClinicalAnalysisLaboratory , Address chars=>1
     */
    @Test
    public void testCheckNHSID1() {
        try{
            Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkAddressRules method, of class ClinicalAnalysisLaboratory , Address chars>1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNHSID2() {
        Client cl = new Client("Joana","1234567890123456","18/05/2201","12345678 0","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkAddressRules method, of class ClinicalAnalysisLaboratory , Address chars<30
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNHSID3() {
        Client cl = new Client("Joana","1234567890123456","18/05/2201","","1234567890","contribute@geeksforgeeks.org","12345678901");
    }
    /**
     * Mutation Test of checkAddressRules method, of class ClinicalAnalysisLaboratory , Address chars==30
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNHSID4() {
        Client cl = new Client("Joana","1234567890123456","18/05/2201","1234a67890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
    }
    //LABID TEST
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars!=5
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCCRules1() {
        Client cl = new Client("Joana","","18/05/2201","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars!=5
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCCID2() {
        Client cl = new Client("Joana","1234567 90123456","18/05/2201","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars!=5
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCC3() {
        Client cl = new Client("Joana","12345678A0123456","18/05/2201","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
    }
    /**
     * Mutation Test of checkLabIDRules method, of class ClinicalAnalysisLaboratory , LaboratoryID chars==5
     */
    @Test
    public void testCheckCC5() {
        try{
            Client cl = new Client("Joana","1234567890123456","18/05/1991","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
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
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        String exp = "Client{" +
                "name='" + "Joana" + '\'' +
                ", email=" + "contribute@geeksforgeeks.org" +
                ", nhsid='" + "1234567890" + '\'' +
                ", tin='" + "1234567890" + '\'' +
                ", cc='" + "1234567890123456" + '\'' +
                ", birth='" + "18/05/2001" + '\'' +
                ", sex='" + "Female" + '\'' +
                ", phonenumber='" + "12345678901" + '\'' +
                '}';
        String actual = cl.toString();
        assertEquals(exp, actual);
    }
    // NAME TEST
  /**
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars<20
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckSex2() {
        Client cl = new Client("1234567890123456789012345678901234567","1234567890123456","18/05/2201","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Shemale");
    }
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars=>1
     */
    @Test
    public void testCheckSex3() {
        try{
            Client cl = new Client("J","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars>=20
     */
    @Test
    public void testCheckSex4() {
        try {
            Client cl = new Client("1234567890123456789012345678901234", "1234567890123456", "18/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Male");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException");
        }
    }
    @Test
    public void testCheckSex5() {
        try {
            Client cl = new Client("1234567890123456789012345678901234", "1234567890123456", "18/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Other");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException");
        }
    }
    // Birth TEST
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars>1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckBirth1() {
        Client cl = new Client("Joana","1234567890123456","","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","");
    }
    @Test
    public void testCheckBirth2() {
        try {
            Client cl = new Client("12345678901234567890123", "1234567890123456", "31/12/1870", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Other");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException");
        }
    }

    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars=>1
     */
    @Test
    public void testCheckBirth3() {
        try{
            Client cl = new Client("J","1234567890123456","31/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    /**
     * Mutation Test of checkNameRules method, of class ClinicalAnalysisLaboratory , Name chars>=20
     */
    public void testCheckBirth4() {
        try{
            Client cl = new Client("J","1234567890123456","31/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }
    public void testCheckBirth5() {
        try{
            Client cl = new Client("J","1234567890123456","30/18/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLstTesComplete(){
        List<app.domain.model.Test> lstTests = new ArrayList<>();
        Client cl = new Client("J","1234567890123456","30/18/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        app.domain.model.Test t = new app.domain.model.Test("2345");
        t.setClient(cl);
        app.domain.model.Test t2 = new app.domain.model.Test("2345");
        t2.setClient(cl);
        app.domain.model.Test t3 = new app.domain.model.Test("2345");
        t3.setClient(cl);
        lstTests.add(t);
        lstTests.add(t2);
        lstTests.add(t3);

        assertEquals(lstTests, cl.getLstTestComplete());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckBirth6() {

        Client cl = new Client("123456789012345678901234567890", "1234567890123456", "32/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Other");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCheckBirth7() {

        Client cl = new Client("123456789012345678901234567890", "1234567890123456", "30/13/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Other");
    }

    @Test
    public void testClientData() {
        System.out.println("clientData");
        Client client = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        String exp = "1) Name: Joana\n" +
                "2) Birth date: 18/05/2001\n" +
                "3) NHS id: 1234567890\n" +
                "4) Phone number: 12345678901\n" +
                "5) E-mail: contribute@geeksforgeeks.org\n" +
                "6) Gender: Female\n" +
                "7) Password: password";
        String actual = client.clientData("password").toString();
        assertEquals(exp, actual);
    }
}







