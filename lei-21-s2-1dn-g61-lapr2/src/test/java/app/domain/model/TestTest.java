/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class TestTest {

    /**
     * Test 1: Constructor of Test class.
     */
    @Test
    public void testTestConstructor() {
        System.out.println("Create Test");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        boolean testAttributes = (instance.getNHScode().compareTo(nh) == 0);

        assertTrue(testAttributes);
    }

    @Test
    public void generateBarcode(){
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        String code = instance.generateCode();

        assertEquals(code, code);
    }

    /**
     * Test 2: setCode & getCode methods, of class Test.
     */
    @Test
    public void testSetCode() {
        System.out.println("setDescription");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        String expected = "123456789012";
        instance.setCode(expected);
        String result = instance.getCode();

        assertEquals(result, expected);
    }

    /**
     * Test 3: checkCodeRules method, of class Test. Code != 12
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules1() {
        System.out.println("checkCodeRules");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);
        instance.setCode("12345");
    }

    /**
     * Test 4: checkCodeRules method, of class Test. Code = "     "
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules2() {
        System.out.println("checkCodeRules");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);
        instance.setCode("            ");
    }

    /**
     * Test 5: setNHScode & getNHScode method, of class Test.
     */
    @Test
    public void testSetNHSID() {
        System.out.println("setNHSID");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        String expected = "993456789012";
        instance.setNHScode(expected);
        String result = instance.getNHScode();

        assertEquals(result, expected);
    }

    /**
     * Test 6: checkNHSRules method, of class Test. NHSID chars != 12
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNHSRules1() {
        System.out.println("checkNHSRules");
        String nh = "54321";
        app.domain.model.Test instance = new app.domain.model.Test(nh);
        instance.checkNHSRules(nh);
    }

    /**
     * Test 7: checkNHSRules method, of class Test. NHSID chars empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckNHSRules2() {
        System.out.println("checkNHSRules");
        String nh = "            ";
        app.domain.model.Test instance = new app.domain.model.Test(nh);
        instance.checkNHSRules(nh);
    }

    /**
     * Test 8: setClient & getClient methods, of class Test.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        Client c1 = new Client("Joana", "1234567890123456", "8/05/2001", "1234567890", "1234567890", "contribute@geeksforgeeks.org", "12345678901", "Female");
        instance.setClient(c1);

        Client expected = new Client("Kara", "9234567890123456", "8/05/2001", "1234567890", "1234567890", "contribut@gksforgeeks.org", "12345678901", "Female");
        instance.setClient(expected);
        Client result = instance.getClient();

        assertEquals(result, expected);
    }

    /**
     * Test 9: setTestType/getTestType methods, of class Test.
     */
    @Test
    public void testSetTestType() {
        System.out.println("setTestType");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        TestType tt = new TestType("tt003", "UrineTest", "Urine");
        instance.setTestType(tt);

        TestType expected = new TestType("tt004", "SalivaTest", "Saliva");
        instance.setTestType(expected);
        TestType result = instance.getTestType();

        assertEquals(result, expected);
    }

    /**
     * Test 10: addTestParameter/getParameter methods, of class Test.
     */
    @Test
    public void testAddTestParameter() {
        System.out.println("addTestParameter");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        ParameterCategory pc = new ParameterCategory("12345", "this is a description", "12345");
        Parameter expected = new Parameter("12345", "description", pc);

        instance.addTestParameter(expected);
        Parameter result = instance.getTestParameters().get(0);

        assertEquals(result, expected);
    }

    /**
     * Test 11: addTestParameter/getParameter methods, of class Test.
     */
    @Test
    public void testAddTestParameter2() {
        System.out.println("addTestParameter");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        ParameterCategory pc = new ParameterCategory("12345", "this is a description", "12345");
        Parameter p = new Parameter("12345", "description", pc);

        instance.addTestParameter(p);
        instance.addTestParameter(p);
        instance.addTestParameter(p);

        int expected = 1;
        int result = instance.getTestParameters().size();

        assertEquals(expected, result);
    }

    /**
     * Test 12: toString method, of class Test
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String nh = "123456789012";
        app.domain.model.Test instance = new app.domain.model.Test(nh);

        String expected = "Code: " + instance.getCode() + "\nNHS code: 123456789012";
        String result = instance.toString();

        assertEquals(expected, result);
    }

    /**
     * Test 13: setDataSample & getDataSample, of class Test
     */
    @Test
    public void testSetGetDateSample() {
        System.out.println("setDateSample");

        app.domain.model.Test instance = new app.domain.model.Test("123451234512");

        instance.setDateSample();
        Date d = new Date();
        String expected = d.toYMDString();
        String result = instance.getDateSample();

        assertEquals(expected, result);
    }

    @Test
    public void testSetGetDateRegistration() {
        System.out.println("setDateRegistration");

        app.domain.model.Test instance = new app.domain.model.Test("123451234512");

        instance.setDateRegistration();
        Date d = new Date();
        String expected = d.toYMDString();
        Date result = instance.getDateRegistration();

        assertEquals(expected, result.toYMDString());
    }

    /**
     * Test 14: setDataChemAnalysis & getDataChemAnalysis, of class Test
     */
    @Test
    public void testSetGetDateChemAnalysis() {
        System.out.println("setDateChemAnalysis");


        app.domain.model.Test instance = new app.domain.model.Test("123451234512");
        instance.setDateChemAnalysis();
        Date d = new Date();

        String expected = d.toYMDString();
        String result = instance.getDateChemAnalysis();

        assertEquals(expected, result);
    }

    /**
     * Test 15: setDataDiagnosis & getDataDiagnosis, of class Test
     */
    @Test
    public void testSetGetDateDiagnosis() {
        System.out.println("setDateDiagnosis");

        app.domain.model.Test instance = new app.domain.model.Test("123451234512");
        instance.setDateDiagnosis();
        Date d = new Date();

        String expected = d.toYMDString();
        String result = instance.getDateDiagnosis();

        assertEquals(expected, result);
    }

    /**
     * Test 16: setDataValidTest & getDataValidTest, of class Test
     */
    @Test
    public void testSetGetDateValidTest() {
        System.out.println("setDateSample");

        app.domain.model.Test instance = new app.domain.model.Test("123451234512");

        instance.setDateValidTest();
        Date d = new Date();

        String expected = d.toYMDString();
        String result = instance.getDateValidTest().toYMDString();

        assertEquals(expected, result);
    }


    /**
     * Test 17: setTimeSample & getTimeSample, of class Test
     */
    @Test
    public void testSetGetTimeSample() {
        System.out.println("setTimeSample");


        app.domain.model.Test instance = new app.domain.model.Test("123451234512");
        instance.setTimeSample();
        Time d = new Time();

        String expected = d.toString();
        String result = instance.getTimeSample();

        assertEquals(expected, result);
    }

    @Test
    public void testSetGetTimeRegistration() {
        System.out.println("setTimeRegistration");


        app.domain.model.Test instance = new app.domain.model.Test("123451234512");
        instance.setTimeRegistration();
        Time d = new Time();

        String expected = d.toString();
        Time result = instance.getTimeRegistration();

        assertEquals(expected, result.toString());
    }

    /**
     * Test 18: setTimeChemAnalysis & getTimeChemAnalysis, of class Test
     */
    @Test
    public void testSetGetTimeChemAnalysis() {
        System.out.println("setTimeChemAnalysis");


        app.domain.model.Test instance = new app.domain.model.Test("123451234512");
        instance.setTimeChemAnalysis();
        Time d = new Time();

        String expected = d.toString();
        String result = instance.getTimeChemAnalysis();

        assertEquals(expected, result);
    }

    /**
     * Test 19: setTimeDiagnosis & getTimeDiagnosis, of class Test
     */
    @Test
    public void testSetGetTimeDiagnosis() {
        System.out.println("setTimeDiagnosis");

        app.domain.model.Test instance = new app.domain.model.Test("123451234512");
        instance.setTimeDiagnosis();
        Time d = new Time();

        String expected = d.toString();
        String result = instance.getTimeDiagnosis();

        assertEquals(expected, result);
    }

    /**
     * Test 20: setTimeValidTest & getTimeValidTest, of class Test
     */
    @Test
    public void testSetGetTimeValidTest() {
        System.out.println("setTimeSample");


        app.domain.model.Test instance = new app.domain.model.Test("123451234512");

        instance.setTimeValidTest();
        Time d = new Time();
        String expected = d.toString();
        String result = instance.getTimeValidTest().toString();

        assertEquals(expected, result);
    }

    /**
     * Test 21: setCategory & getCategory, of class Test
     */
    @Test
    public void testTestCategory() {
        ParameterCategory pc = new ParameterCategory("12345", "ddd", "123456");
        app.domain.model.Test instance = new app.domain.model.Test("123451234512");
        instance.setCategory(pc);
        String expected = pc.toString();
        String result = instance.getTestCategory().toString();

        assertEquals(expected, result);
    }

    /**
     * Test 22: Test of CheckDate state, of class Test
     */
    @Test
    public void testCheckDateState() {
        int cont = 1;
        String nhs = "000000000005";
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        t1.setDateSample();
        int result = t1.checkTestState();
        assertEquals(result, cont);
    }

    /**
     * Test 23: Test of CheckDate state, of class Test
     */
    @Test
    public void testCheckDateState1() {
        int cont = 2;
        String nhs = "000000000005";
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        t1.setDateSample();
        t1.setDateChemAnalysis();
        int result = t1.checkTestState();
        assertEquals(result, cont);
    }

    /**
     * Test 24: Test of CheckDate state, of class Test
     */
    @Test
    public void testCheckDateState2() {
        int cont = 3;
        String nhs = "000000000005";
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        t1.setDateSample();
        t1.setDateChemAnalysis();
        t1.setDateDiagnosis();
        int result = t1.checkTestState();
        assertEquals(result, cont);
    }

    /**
     * Test 25: Test of CheckDate state, of class Test
     */
    @Test
    public void testCheckDateState3() {
        int cont = 4;
        String nhs = "000000000005";
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        t1.setDateSample();
        t1.setDateChemAnalysis();
        t1.setDateDiagnosis();
        t1.setDateValidTest();
        int result = t1.checkTestState();
        assertEquals(result, cont);
    }

    /**
     * Test 26: Test of CheckDate state, of class Test
     */
    @Test
    public void testCheckDateState4() {
        int cont = 0;
        String nhs = "000000000005";
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        int result = t1.checkTestState();
        assertEquals(result,cont);
    }

    /**
     * Test 27: Test of CheckDate state, of class Test
     */
    @Test
    public void testCheckDateState5() {
        int cont = 1;
        String nhs = "000000000005";
        app.domain.model.Test t1 = new app.domain.model.Test(nhs);
        int result = t1.checkTestState();
        assertNotEquals(result,cont);
    }

    /**
     * Test 28: Test of addSample & getSamples, of class Test
     */
    @Test
    public void testAddSample(){
        Sample expected = new Sample("123451234512");
        app.domain.model.Test instance = new app.domain.model.Test("123456123456");
        instance.addSample(expected);
        Sample result = instance.getSamples().get(0);
        assertEquals(expected, result);
    }

    /**
     * Test 29: Test of setDescription & getDescription, of class Test
     */
    @Test
    public void testSetDescription(){
        app.domain.model.Test instance = new app.domain.model.Test("123456123456");
        String expected = "description";
        instance.setDescription(expected);
        String result = instance.getDescription();
        assertEquals(expected, result);
    }

    /**
     * Test 30: Test of addTestResult
     */
   /* @Test
    public void testAddTestResult() throws IOException {
        app.domain.model.Test instance = new app.domain.model.Test("123456123456");
        ParameterCategory pc = new ParameterCategory("pc002", "ddd", "123456");
        Parameter p = new Parameter("RBC00", "ddd", pc);
        TestType tt = new TestType("tt002", "blood", "blood");

        instance.setTestType(tt);
        instance.addTestParameter(p);

        TestParameter tp = instance.addTestResult("RBC00", "333", "ml");
        assertTrue(tp != null);
    }*/


    /**
     * Test 31: temporary test method
     */
    @Test
    public void testTest2(){
        app.domain.model.Test instance = new app.domain.model.Test("123456789012");
        assertNotNull(instance);
    }

    /**
     * Test 32: see if the sample is created right and added right
     */
    /*@Test
    public void testCreateSample() {
        String nh = "123456789012";
        String description = "test";
        app.domain.model.Test t = new app.domain.model.Test(nh);
        t.setDescription(description);
        TestType tt = new TestType("tt009", "Urine", "123456");
        t.setTestType(tt);
        assertTrue(t.createSample());
    }*/

    @Test
    public void getTestParametersFor(){
        Parameter parameter = new Parameter("12340", "iuytdxgf", new ParameterCategory("12345", "uiytghvjb", "87654"));
        TestParameter testParameter1 = new TestParameter(parameter);
        Parameter parameter2 = new Parameter("09840", "ergdfxgf", new ParameterCategory("34521", "dfghngb", "895654"));
        TestParameter testParameter2= new TestParameter(parameter2);
        Parameter parameter3 = new Parameter("45340", "wergth", new ParameterCategory("12985", "werghnb", "29654"));
        TestParameter testParameter3 = new TestParameter(parameter3);
        app.domain.model.Test test = new app.domain.model.Test("123456789012");

        List<TestParameter> testParameters = new ArrayList<>();
        testParameters.add(testParameter1);
        testParameters.add(testParameter3);
        testParameters.add(testParameter2);

        assertNull(test.getTestParameterFor("87654"));
    }

    @Test
    public void compareTo(){
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        app.domain.model.Test test2 = new app.domain.model.Test("098765432121");
        test.setCode("000000000001");
        test2.setCode("000000000002");

        assertEquals(1, test.compareTo(test2));

        assertEquals(- 1, test2.compareTo(test));


        test.setCode("000000000002");
        test2.setCode("000000000002");

        assertEquals(0, test2.compareTo(test));

    }

}
