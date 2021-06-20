package app.controller;

import app.domain.model.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Miguel Chen 1190897
 */
public class ManualReportController {
    /**
     * the Sender is used to send Report to the NHS
     */
    private Sender sd;
    /**
     * the TestValideStore is used to validate and save the test
     */
    private TestValideStore store;
    /**
     * the company that validates the work
     */
    private Company company;

    /**
     * Creates a controller getting the Company information from App
     */
    public ManualReportController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
        this.store = this.company.getValidationStore();
        this.sd=new Sender();
    }

    /**
     * Creates a controller from the Company, having it as a parameter
     * @param company
     */
    public ManualReportController(Company company) {
        this.company = company;
    }
    /**
     * Builds a String with the daily covid cases and its average
     * @return String with the data
     */
    public String showReport(String alg,String it) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Test> list = this.store.getTestsValids();
        int day = 0;
        StringBuilder sb = new StringBuilder();
      /*  System.out.println("Choose 1 of 2 algorithms(Linear and Multi) ");
        String alg = sc.next();
        sc.nextLine();
        System.out.println("Write the Interval");
        String intv = sc.next();*/
        sb.append(alg+"\n"+"\n"+it+"\n"+"\n");
        sb.append("Date          Cases         \n");
        Collections.sort(list,App.sortD());
        for (Test t : list){
            int cases = store.covidCasesPerDay(t.getDateValidTest().toYMDString());

            if (day != t.getDateValidTest().getDay()){
                String case1 = String.format("%02d", cases);
                sb.append(t.getDateValidTest().toYMDString()+"          "+case1+ "\n");
                day = t.getDateValidTest().getDay();
            }
        }
        return sb.toString();
    }

    /**
     * Sends report to the NHS
     * @param report
     */
    public void send(String report){
        this.sd.sender(report);
    }
}
