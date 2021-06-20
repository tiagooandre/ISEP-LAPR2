package app.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Timer;

public class AutoReportNHSTest {
    public static final Timer timer = new Timer();

    @Test
    public void testSendReport() {
        System.out.printf("sendReport()");
        Time now = new Time();

        int seconds = now.getSeconds() - now.getMinutes()/60 - now.getHours()/360;
        int sendTime = 30 + 10*60 + 22*360;

        assertNotEquals(sendTime, seconds);
    }


    @Test
    public void testSendReport2() {
        System.out.printf("sendReport2()");
        Time now = new Time();

        int seconds = now.getSeconds() - now.getMinutes()/60 - now.getHours()/360;
        int sendTime = 0 + 0*60 + 0*360;

        assertNotEquals(sendTime, seconds);
    }
}
