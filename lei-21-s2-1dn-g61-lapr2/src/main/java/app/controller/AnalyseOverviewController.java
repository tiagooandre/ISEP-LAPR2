package app.controller;

import app.domain.model.*;

import java.io.IOException;

public class AnalyseOverviewController {

    /**
     * the TestStore is used to see the tests
     */
    private TestStore ts;
    /**
     * the company that has TestStore
     */
    private Company company;

    /**
     * Creates a controller getting the Company information from App
     */
    public AnalyseOverviewController()  {
        try {
            this.company = App.getInstance().getCompany();
            this.ts = this.company.getTestStore();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the number of clients registered in the company
     */
    public int getNumberClients() {
        return company.getClientStore().getClients().size();
    }

    /**
     * @return the total number of tests processed in the laboratory
     */
    public int getTestsProcessed() {
        /*
        int count = 0;
        for (Test t : ts.getTests()) {
            if (t.checkTestState() == 4) {
                count++;
            }
        }
         */
        return company.getTestValideList().size();
    }


    /**
     * @return a string with the data interval that correspond to the contiguous sequence
     */
    public String calculatesInterval(Date beginningDate, Date endDate)  {
        ContiguousSubsequence css = new ContiguousSubsequence();
        return css.subSequenceTimeInterval(beginningDate, endDate, ts.getTests());
    }


}
