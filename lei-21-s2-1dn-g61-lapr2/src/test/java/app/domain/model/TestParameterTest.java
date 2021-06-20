package app.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestParameterTest {
    @Test
    public void testGetParameter() {
        System.out.printf("getParameter\n");
        ParameterCategory cat = new ParameterCategory("1234", "category", "12345");
        Parameter p = new Parameter("1234", "Parameter", cat);
        TestParameter tp = new TestParameter(p);

        assertEquals(tp.getParameter(), p);
    }

    @Test
    public void testAddResultAndGetTestResult() {
        System.out.printf("addResult\n");
        Date date = new Date();
        ReferenceValue rv = new ReferenceValue("1234", "ml", 50, 300, date);
        TestParameterResult tpr = new TestParameterResult("Positive", "ml", rv);
        ParameterCategory cat = new ParameterCategory("1234", "Category", "12345");
        Parameter p = new Parameter("1234", "Parameter", cat);
        TestParameter tp = new TestParameter(p);

        tp.addResult("Positive", "ml", rv);
        assertEquals(tpr.toString(), tp.getTestResult().toString());
    }

   @Test
    public void testToString() {
        System.out.printf("toString()\n");
        Date date = new Date();
        ReferenceValue rv = new ReferenceValue("1234", "ml", 50, 300, date);
        TestParameterResult tpr = new TestParameterResult("Positive", "ml", rv);
        ParameterCategory cat = new ParameterCategory("1234", "Category", "12345");
        Parameter p = new Parameter("1234", "Parameter", cat);
        TestParameter tp = new TestParameter(p);
        tp.addResult("Positive", "ml", rv);

        String expRes = "Parameter: Parameter\n"
                + "Parameter Test Results:\nResult: Positive\n" +
                "Metric: ml\n" +
                "Reference Value: Parameter Code: 1234\n" +
                "Min reference value: 50.000000\n" +
                "Max reference value: 300.000000\n" +
                "Used Metric: ml\n" +
                "Date: " + date;

        assertEquals(expRes, tp.toString());
    }

    /*
    @Test
    public void testToString2() {
        System.out.printf("toString2()\n");
        Date date = new Date();
        ReferenceValue rv = new ReferenceValue("1234", "ml", 50, 300, date);
        TestParameterResult tpr = new TestParameterResult("Positive", "ml", rv);

        String expRes = "" + "Result: Positive\n" +
                "Metric: ml\n" +
                "Reference Value: Parameter Code: 1234\n" +
                "Min reference value: 50.000000\n" +
                "Max reference value: 300.000000\n" +
                "Used Metric: ml\n" +
                "Date: " + date;

        assertEquals(expRes, tpr.);
    }*/

    @Test
    public void testToString2() {
        System.out.printf("toString2()\n");
        Date date = new Date();
        ReferenceValue rv = new ReferenceValue("1234", "ml", 50, 300, date);
        TestParameterResult tpr = new TestParameterResult("Positive", "ml", rv);
        ParameterCategory cat = new ParameterCategory("1234", "Category", "12345");
        Parameter p = new Parameter("1234", "Parameter", cat);
        TestParameter tp = new TestParameter(p);
        tp.addResult("Positive", "ml", rv);

        String expRes = "" + "Result: Positive\n" +
                "Metric: ml\n" +
                "Reference Value: Parameter Code: 1234\n" +
                "Min reference value: 50.000000\n" +
                "Max reference value: 300.000000\n" +
                "Used Metric: ml\n" +
                "Date: " + date;

        assertEquals(expRes, tp.toString2());
    }
}
