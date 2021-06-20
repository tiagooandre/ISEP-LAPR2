package app.domain.model;


import com.isep.mdis.Sum;

import java.time.LocalDateTime;
import java.util.List;

public class ContiguousSubsequence {

    /**
     * The hour when the work starts
     */
    private final int WORKING_HOUR_DAY_START = 8;
    /**
     * The hour when the work ends
     */
    private final int WORKING_HOUR_DAY_END = 20;
    /**
     * The number of hours of work per day
     */
    private final int HOURS_DAY = 24;
    /**
     * The number of minutes that is used to calculate the contiguous subsequence
     */
    private final int SEQUENCE_MINUTES = 30;


    public ContiguousSubsequence() {}

    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @param listTests a list with all the tests registered in the company
     * @return a sequence with number of tests in different intervals
     */
    public String subSequenceTimeInterval(Date beginningDate, Date endDate, List<Test> listTests) {
        int[] sequence = createSequence(beginningDate, endDate, listTests);
        int[] subSequence = generatesSubSequence(sequence);
        if (subSequence.length != 0) {
            int index = findSequenceIndex(sequence, subSequence);
            if (index != -1) {
                LocalDateTime beginningDateAux = LocalDateTime.of(beginningDate.getYear(), beginningDate.getMonth(), beginningDate.getDay(), WORKING_HOUR_DAY_START, 0);
                LocalDateTime endDateAux = LocalDateTime.of(beginningDate.getYear(), beginningDate.getMonth(), beginningDate.getDay(), WORKING_HOUR_DAY_START, 0);
                beginningDateAux = beginningDateAux.plusMinutes(index * SEQUENCE_MINUTES);
                index = index + subSequence.length;
                endDateAux = endDateAux.plusMinutes(index * SEQUENCE_MINUTES);
                return (beginningDateAux.toString() + "    " + endDateAux.toString());
            }
            System.out.println("wa");
        }
        return "There is no subsequence.";
    }

    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @param listTests a list with all the tests registered in the company
     * @return a sequence with number of tests in different intervals
     */
    public int[] createSequence(Date beginningDate, Date endDate, List<Test> listTests) {
        int numberIndexs = elementsInSequence(beginningDate, endDate);
        int[] sequence = new int[numberIndexs];
        LocalDateTime controlBeginningDate = LocalDateTime.of(beginningDate.getYear(), beginningDate.getMonth(), beginningDate.getDay(), WORKING_HOUR_DAY_START, 0);
        LocalDateTime controlEndDate = LocalDateTime.of(beginningDate.getYear(), beginningDate.getMonth(), beginningDate.getDay(), WORKING_HOUR_DAY_START, 0);

        for (int i = 0; i < numberIndexs; i++) {
            controlEndDate = controlEndDate.plusMinutes(SEQUENCE_MINUTES);
            if (controlBeginningDate.getHour()==WORKING_HOUR_DAY_END) {
                controlBeginningDate = controlBeginningDate.plusHours(HOURS_DAY-WORKING_HOUR_DAY_END+WORKING_HOUR_DAY_START);
                controlEndDate = controlBeginningDate.plusMinutes(SEQUENCE_MINUTES);
            }
            int numberRegisteredTests = getNumberRegisteredTests(controlBeginningDate, controlEndDate, listTests, 0);
            int numberResultedTests = getNumberRegisteredTests(controlBeginningDate, controlEndDate, listTests, 4);
            sequence[i] = numberResultedTests - numberRegisteredTests;
            controlBeginningDate = controlBeginningDate.plusMinutes(SEQUENCE_MINUTES);
        }
        return sequence;
    }

    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @return return the number of elements that need to be in the sequence
     */
    public int elementsInSequence(Date beginningDate, Date endDate) {
        return numberDays(beginningDate, endDate) * (WORKING_HOUR_DAY_END-WORKING_HOUR_DAY_START) * 2;
    }

    /**
     * Calls a method in class Date
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @return difference in number of days between the date and the date received by parameter
     */
    public int numberDays(Date beginningDate, Date endDate) {
        return beginningDate.calculateDifference(endDate) + 1;
    }

    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @param listTests a list with all the tests registered in the company
     * @param status the state of the test
     * @return integer with the number of tests with the same state and thar are in the time interval
     */
    public int getNumberRegisteredTests(LocalDateTime beginningDate, LocalDateTime endDate, List<Test> listTests, int status) {
        int count = 0;
        LocalDateTime testDate = null;
        for (Test t: listTests) {
            if (t.checkTestState() == status) {
                switch (status) {
                    case 0 : testDate = LocalDateTime.of(t.getDateRegistration().getYear(), t.getDateRegistration().getMonth(), t.getDateRegistration().getDay(), t.getTimeRegistration().getHours(), t.getTimeRegistration().getMinutes(), t.getTimeRegistration().getSeconds());
                        break;
                    case 4 : testDate = LocalDateTime.of(t.getDateValidTest().getYear(), t.getDateValidTest().getMonth(), t.getDateValidTest().getDay(), t.getTimeValidTest().getHours(), t.getTimeValidTest().getMinutes(), t.getTimeValidTest().getSeconds());
                        break;
                }
                if (checkInterval(beginningDate, endDate, testDate)) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * @param beginningDate the start of the interval
     * @param endDate the end of the interval
     * @return true if the date is between beginingDate and endDate
     */
    public boolean checkInterval(LocalDateTime beginningDate, LocalDateTime endDate, LocalDateTime testDate) {
        if ((testDate.getYear() == beginningDate.getYear()) && (testDate.getMonth() == beginningDate.getMonth()) && (testDate.getDayOfMonth() == beginningDate.getDayOfMonth()) && (testDate.getHour() == beginningDate.getHour())) {
            if ((testDate.getMinute() >= beginningDate.getMinute()) && (testDate.getMinute() <= endDate.getMinute())) {
                if ((testDate.getMinute() == endDate.getMinute()) && (testDate.getSecond() != 0)) {
                    return false;
                } else {
                    return  true;
                }
            }
        }
        return false;
    }

    /**
     * @param sequence the sequence with all the numbers
     * @return the subSequence -> the sequence created with using contigous Subsequence with maximus sum
     */
    public int[] generatesSubSequence(int[] sequence) {
        return Sum.Max(sequence);
    }


    /**
     * @param sequence the sequence with all the numbers
     * @param subSequence the sequence created with the contigous Subsequence
     * @return the index where the subSequence stars in the sequence
     */
    public int findSequenceIndex(int[] sequence, int[] subSequence) {
        int index=0, j=0;
        boolean flag = false;
        for (int i = 0; i < sequence.length; i++) {
            if (subSequence[j] == sequence[i]) {
                if (!flag) {
                    index = i;
                }
                flag = true;
                j++;
                if (j == subSequence.length) {
                    return index;
                }
            } else {
                flag = false;
                j = 0;
            }
        }
        return -1;
    }

    public void testPrint(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i]);
        }
        System.out.println();
    }
}
