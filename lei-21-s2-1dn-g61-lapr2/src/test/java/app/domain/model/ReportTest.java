package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReportTest {
    @Test
    public void setText(){
        System.out.println("setText");
        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola",d1);

        r1.setText("oli");
        String result = "oli";
        assertEquals(result,r1.getText());
    }

    @Test
    public void setDiagnosis(){
        System.out.println("setText");
        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola",d1);

        app.domain.model.ParameterCategory pc1 = new ParameterCategory("09876","ola1344","12345");
        Parameter pa1 = new Parameter("01234","ola324",pc1);
        TestParameter t11 = new TestParameter(pa1);
        List<TestParameter> list1 = new ArrayList<>();
        list.add(t11);
        Diagnosis d2 = new Diagnosis(list1);
        r1.setDiagnosis(d2);


        assertEquals(d2,r1.getDiagnosis());

    }
    @Test
    public void testtoString(){
        System.out.println("TostringTest");
        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola",d1);

        String result = r1.toString();
        String actual = "### Report ### \n" +
                "Text: ola\n" +
                "Diagnosis: ### Diagnosis ### \n" +
                "Diagnosis: [Parameter: ola\n" +
                "Parameter Test Results:\n" +
                "null]";
        assertNotEquals(result,actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckText1(){
        System.out.println("checkTest");
        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t\n" +
                "T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t\n" +
                "T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t\n" +
                "T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t\n",d1);


    }
    @Test
    public void testCheckText2(){
        System.out.println("checkTest");
        try{
            app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
            Parameter pa = new Parameter("01234","ola",pc);
            TestParameter t1 = new TestParameter(pa);
            List<TestParameter> list = new ArrayList<>();
            list.add(t1);
            Diagnosis d1 = new Diagnosis(list);
            Report r1 = new Report("t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t\n" +
                    "T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t\n" +
                    "T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t\n" +
                    "T t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t t\n",d1);

        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException");
        }

    }

    @Test
    public void testToString() {
        System.out.println("toString()");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola",d1);

        app.domain.model.ParameterCategory pc1 = new ParameterCategory("09876","ola1344","12345");
        Parameter pa1 = new Parameter("01234","ola324",pc1);
        TestParameter t11 = new TestParameter(pa1);
        List<TestParameter> list1 = new ArrayList<>();
        list.add(t11);
        Diagnosis d2 = new Diagnosis(list1);
        r1.setDiagnosis(d2);

        String expRes = "### Report ### \n" + "Text: " + r1.getText() + "\n" + "Diagnosis: " + r1.getDiagnosis() + "\n";

        assertEquals(expRes, r1.toString());
    }

}