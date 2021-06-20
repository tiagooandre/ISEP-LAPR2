package app.domain.model;
import java.util.*;

/**
 * Sends daily reports to the NHS concerning the positive covid cases daily
 */
public class AutoReportNHS {
    /**
     * the TestValideStore is used to validate and save the test
     */
    private TestValideStore store;

    /**
     * The timer
     */
    public AutoReportNHS(TestValideStore validTestsStore){
        this.store = validTestsStore;
    }



    public static final Timer timer = new Timer();

    public void sendReport(){

        Time now = new Time();
        int seconds = now.getSeconds() + now.getMinutes()*60 + now.getHours()*360;
        int sendTime = 0*30 + 0*60 + 6*360;

        if(seconds<sendTime)
            timer.schedule(new Reporter(), (sendTime-seconds)* 1000L, 86400*1000L);
        else
            timer.schedule(new Reporter(), (86400 - (seconds-sendTime))* 1000L, 86400*1000L);
    }

    class Reporter extends TimerTask{
        public void run(){
            List<Test> testList = store.getTestsValids();
            int day = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("Date          Cases      \n");
            for (Test t : testList){
                int cases = store.covidCasesPerDay(t.getDateRegistration().toYMDString());
                if (day != t.getDateValidTest().getDay()){
                    String case1 = String.format("%02d", cases);
                    sb.append(t.getDateRegistration().toYMDString()+"          "+case1+          "\n");
                    day = t.getDateValidTest().getDay();
                }
            }
            Sender s = new Sender();
            s.sender(sb.toString());
        }
    }



}
