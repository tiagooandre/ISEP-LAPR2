package app.controller;

import app.domain.model.*;

import java.io.IOException;
import java.util.List;

public class StatisticsController {

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
    public StatisticsController()  {
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
     * @return a list with two dates, the first is the date more old where a test was registered and the second is the newest
     */
    public Date[] firstAndLastDate() {
        List<Test> listTests = ts.getTests();
        Date dateInicial = new Date();
        Date dateEnd = new Date("0/0/0");
        for (Test t: listTests) {
            if (t.getDateRegistration().compareTo(dateInicial)==-1) {
                dateInicial = t.getDateRegistration();
            }
            if (t.getDateRegistration().compareTo(dateEnd)==1) {
                dateEnd = t.getDateRegistration();
            }
        }
        Date[] dates = {dateInicial, dateEnd};
        return dates;
    }

    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @return a list with all the years between the beginningDate and the endDate
     */
    public String[] getYearsDate(Date beginningDate, Date endDate) {
        return beginningDate.datesYear(endDate);
    }

    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @return a list with all the moths between the beginningDate and the endDate
     */
    public String[] getMonthsDate(Date beginningDate, Date endDate) {
        return beginningDate.datesMonth(endDate);
    }

    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @return a list with all the weeks between the beginningDate and the endDate
     */
    public String[] getWeeksDate(Date beginningDate, Date endDate) {
        return beginningDate.weeksDay(endDate);
    }

    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @return a list with all the days between the beginningDate and the endDate
     */
    public String[] getDaysDate(Date beginningDate, Date endDate) {
        return beginningDate.datesDay(endDate);
    }

    /**
     * @param arraySize the number of elements that should be in the returned array
     * @param status the state of the test
     * @param interval can be year, month, week or day
     * @return a integerlist  with the number of tests that are in the same state and thar are in the time interval
     */
    public int[] getNumberTests(Date beginDate, int arraySize, String interval, int status) {
        CalculateNumberTests cnt = new CalculateNumberTests();
        return cnt.getNumberRegisteredTestsInterval(beginDate, ts.getTests(), arraySize, interval, status);
    }


}
