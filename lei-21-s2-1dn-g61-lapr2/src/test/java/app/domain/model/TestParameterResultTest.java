package app.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestParameterResultTest {
    @Test
    public void testTestParameterResult() {
        System.out.printf("testParameterResult\n");
        ReferenceValue rf = new ReferenceValue("1234", "ml", 50, 300, null);
        TestParameterResult tpr = new TestParameterResult("Positive", "ml", rf);

        assertTrue(tpr != null);
    }

    @Test
    public void testGetResult() {
        System.out.printf("testGetResult\n");
        ReferenceValue rf = new ReferenceValue("1234", "ml", 50, 300, null);
        TestParameterResult tpr = new TestParameterResult("Positive", "ml", rf);
        String expRes = "Positive";

        assertEquals(expRes, tpr.getResult());
    }

    @Test
    public void testGetRefValue() {
        System.out.printf("testGetRefValue\n");
        ReferenceValue rf = new ReferenceValue("1234", "ml", 50, 300, null);
        TestParameterResult tpr = new TestParameterResult("Positive", "ml", rf);

        assertEquals(tpr.getRefValue(), rf);
    }

    @Test
    public void testToString() {
        System.out.printf("testToString()");
        Date date = new Date();
        ReferenceValue rf = new ReferenceValue("1234", "ml", 50, 300, date);
        TestParameterResult tpr = new TestParameterResult("Positive", "ml", rf);

        String expRed = "Result: Positive\n"
                + "Metric: ml\n"
                + "Reference Value: "+ rf.toString();
    }
}
