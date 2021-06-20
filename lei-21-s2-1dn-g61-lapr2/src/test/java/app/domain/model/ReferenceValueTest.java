package app.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReferenceValueTest {
    @Test
    public void testGetMinRefVal() {
        System.out.printf("getMinRefVal\n");
        ReferenceValue rf = new ReferenceValue("1234", "ml", 50, 300, null);
        double expRes = 50;
        assertEquals(expRes, rf.getMinRefVal(), 0.0);
    }

    @Test
    public void testGetMaxRefVal() {
        System.out.printf("getMaxRefVal\n");
        ReferenceValue rf = new ReferenceValue("1234", "ml", 50, 300, null);
        double expRes = 300;
        assertEquals(expRes, rf.getMaxRefVal(), 0.0);
    }

    @Test
    public void testToString() {
        System.out.printf("toString()\n");
        Date date = new Date();
        ReferenceValue rf = new ReferenceValue("1234", "ml", 50, 300, date);

        String expRes = "Parameter Code: 1234\n"+
                "Min reference value: 50.000000\n" +
                "Max reference value: 300.000000\n" +
                "Used Metric: ml\n" +
                "Date: " + date;

        assertEquals(expRes, rf.toString());
    }
}
