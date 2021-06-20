
package app.domain.model;

import java.util.List;

public class CalculateNumberTests {

    private final int DAYS_PER_WEEK = 7;


    /**
     * @param beginningDate the start of the interval
     * @param listTests a list with all the tests registered in the company
     * @param arraySize the number of elements that should be in the returned array
     * @param status the state of the test
     * @param interval can be year, month, week or day
     * @return integer list with the numbers of tests that are in the same state and thar are in the time interval
     */
    public int[] getNumberRegisteredTestsInterval(Date beginningDate, List<Test> listTests, int arraySize, String interval, int status) {
        int[] numberTests = new int[arraySize];
        Date dateReference = new Date(beginningDate);
        for (int i = 0; i < arraySize; i++) {
            numberTests[i] = getNumberRegisteredTests(dateReference, listTests, interval, status);
            switch (interval) {
                case "year" :
                    dateReference.plusYear(1);
                    break;
                case "month" :
                    dateReference.plusMonth(1);
                    break;
                case "week" :
                    dateReference.plusDay(DAYS_PER_WEEK+1);
                    break;
                case "day" :
                    dateReference.plusDay(1);
                    break;
                default:
                    System.out.println("That interval doesn't exists.");
                    throw new IllegalArgumentException();
            }
        }
        return numberTests;
    }

    /**
     * Calculates the number of test of a specific state that are between a time interval
     * @param beginningDate the start of the interval
     * @param listTests a list with all the tests registered in the company
     * @param status the state of the test
     * @param interval can be year, month, week or day
     * @return integer with the number of tests with the same state and thar are in the time interval
     */
    public int getNumberRegisteredTests(Date beginningDate, List<Test> listTests, String interval, int status) {
        int count = 0;
        Date testDate = null;
        for (Test t: listTests) {
            if (t.checkTestState() == status) {
                switch (status) {
                    case 0 : testDate = t.getDateRegistration();
                        break;
                    case 1 : testDate = t.getRealDateSample();
                        break;
                    case 2 : testDate = t.getRealDateChemAnalysis();
                        break;
                    case 3 : testDate = t.getRealDateDiagnosis();
                        break;
                    case 4 : testDate = t.getDateValidTest();
                        break;
                }
                if (checkInterval(beginningDate, testDate, interval)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @param beginningDate the start of the interval
     * @param testDate the date of the test
     * @param interval can be year, month, week or day
     * @return true if the date is between beginingDate and endDate
     */
    public boolean checkInterval(Date beginningDate, Date testDate, String interval) {
        switch (interval) {
            case "year" :
                if (testDate.getYear() == beginningDate.getYear())
                    return true;
                break;
            case "month" :
                if ((testDate.getYear() == beginningDate.getYear()) && (testDate.getMonth() == beginningDate.getMonth()))
                    return true;
                break;
            case "week" :
                Date dateWeek = new Date(beginningDate.getYear(), beginningDate.getMonth(), beginningDate.getDay()+DAYS_PER_WEEK);
                if ((testDate.compareTo(dateWeek) == -1 || testDate.compareTo(dateWeek) == 0) && (testDate.compareTo(beginningDate) == 1 || testDate.compareTo(beginningDate) == 0)) {
                //if ((testDate.compareTo(dateWeek) != 1) && (testDate.compareTo(beginningDate) !=- 1)) {
                    return true;
                }
                break;
            case "day" :
                if ((testDate.getYear() == beginningDate.getYear()) && (testDate.getMonth() == beginningDate.getMonth()) && (testDate.getDay() == beginningDate.getDay()))
                    return true;
                break;
        }
        return false;
    }

}
