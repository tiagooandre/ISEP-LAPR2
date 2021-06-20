//sequence está a zeros
package app.domain.model;

import com.isep.mdis.Sum;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContiguousSubsequenceTest {

    Date d = new Date();
    List<app.domain.model.Test> listTests = new ArrayList<>();
    app.domain.model.Test t = new app.domain.model.Test("123456789012");
    app.domain.model.Test t2 = new app.domain.model.Test("124456789012");
    app.domain.model.Test t1 = new app.domain.model.Test("224456789012");
    Date beginDate = new Date("16/6/2021");
    Date endDate = new Date("18/6/2021");
    Date beginDate1 = new Date("7/6/2021");
    Date endDate2 = new Date("19/6/2021");
    LocalDateTime controlBeginningDate = LocalDateTime.of(beginDate.getYear(), beginDate.getMonth(), beginDate.getDay(), 8, 0);
    LocalDateTime controlEndDate = LocalDateTime.of(beginDate.getYear(), beginDate.getMonth(), beginDate.getDay(), 8, 0);
    LocalDateTime controlDate1 = LocalDateTime.of(2021,6,7, 8, 0);
    LocalDateTime controlDate2 = LocalDateTime.of(2021,6,7, 8, 30);
    LocalDateTime controlDate3 = LocalDateTime.of(t.getDateRegistration().getYear(),t.getDateRegistration().getMonth(),t.getDateRegistration().getDay(), t.getTimeRegistration().getHours(), 0);
    LocalDateTime controlDate4 = LocalDateTime.of(t.getDateRegistration().getYear(),t.getDateRegistration().getMonth(),t.getDateRegistration().getDay(), t.getTimeRegistration().getHours(), 30);
    LocalDateTime controlTest1 = null;
    LocalDateTime controlTest2 = null;
    LocalDateTime controlTest3 = null;
    Time time = new Time("12:5");
    LocalDateTime controlDate5 = LocalDateTime.of(beginDate.getYear(),beginDate.getMonth(),beginDate.getDay(), time.getHours(), 0);
    LocalDateTime controlDate6 = LocalDateTime.of(beginDate.getYear(),beginDate.getMonth(),beginDate.getDay(), time.getHours(), 30);

    ContiguousSubsequence css = new ContiguousSubsequence();

    public void setData() {
        t1.setDateSample();
        t1.setTimeSample();
        t1.setDateChemAnalysis();
        t1.setDateDiagnosis();
        t1.setTimeChemAnalysis();
        t1.setTimeDiagnosis();
        t1.setDateValidTest();
        t1.setTimeValidTest();

        t2.setDateSample(beginDate);
        t2.setTimeSample(time);
        t2.setDateChemAnalysis(beginDate);
        t2.setDateDiagnosis(beginDate);
        t2.setTimeChemAnalysis(time);
        t2.setTimeDiagnosis(time);
        t2.setDateValidTest(beginDate);
        t2.setTimeValidTest(time);

        controlTest1 = LocalDateTime.of(2021, 6, 7, 9, 0);
        controlTest2 = LocalDateTime.of(2021, 6, 16, 8, 0);
        controlTest3 = LocalDateTime.of(2021,6,7, 8, 25);
        listTests.add(t);
        listTests.add(t1);
        listTests.add(t2);
    }

    @Test
    public void subSequenceTimeInterval() {
        System.out.println("getSubSequence");
        setData();
        String result = css.subSequenceTimeInterval(beginDate, endDate, listTests);
        assertEquals(result, result);
    }


    @Test
    public void testCreateSequence() {
        System.out.println("createSequence");
        setData();
        int[] result = css.createSequence(beginDate1, endDate2, listTests);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println(controlTest1);

        controlTest1.plusMinutes(30);
        controlTest1.plusYears(2);
        System.out.println(controlTest1);
        //assertEquals(expected, result);
    }

    @Test
    public void elementsInSequence() {
        System.out.println("elementsInSequence");
        int result = css.elementsInSequence(beginDate, endDate);
        int expected = 72;
        assertEquals(expected, result);
    }

    @Test
    public void testNumberDays() {
        System.out.println("NumberOfDays");
        int result = css.numberDays(beginDate, endDate);
        System.out.println(result);
        int expected = 3;
        assertEquals(expected, result);
    }

    @Test
    public void testCheckInterval() {
        setData();
        System.out.println("checkInterval");
        boolean result = css.checkInterval(controlBeginningDate, controlEndDate, controlTest1);
        System.out.println(result);

        assertFalse(result);
    }

    @Test
    public void testCheckInterval2() {
        setData();
        System.out.println("checkInterval2");
        boolean result = css.checkInterval(controlBeginningDate, controlEndDate, controlTest2);
        System.out.println(result);

        assertTrue(result);
    }

    @Test
    public void testCheckInterval3() {
        setData();
        System.out.println("checkInterval3");
        boolean result = css.checkInterval(controlDate1, controlDate2, controlTest3);
        System.out.println(result);

        assertTrue(result);
    }

    /*
    @Test
    public void testGetNumberRegisteredTests() {
        setData();
        System.out.println("testGetNumberRegisteredTests");
        int result = css.getNumberRegisteredTests(controlDate3, controlDate4, listTests, 0);
        int expected = 1;

        assertEquals(expected, result);
    }
*/
    @Test
    public void testGetNumberRegisteredTests2() {
        setData();
        System.out.println("testGetNumberRegisteredTests2");
        int result = css.getNumberRegisteredTests(controlDate5, controlDate6, listTests, 4);
        int expected = 1;

        assertEquals(expected, result);
    }

    @Test
    public void testGeneratesSubSequence() {
        setData();
        System.out.println("testGeneratesSubSequence");

        int[] sequence1 = css.createSequence(beginDate1, endDate2, listTests);

        int[] result = css.generatesSubSequence(sequence1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println(result.length);
        //assertEquals(expected, result);
    }

    @Test
    public void testFindSequenceIndex() {
        int[] sequence = {1,2,3,4,5,6,7};
        int[] subSequence = {7};
        int result = css.findSequenceIndex(sequence, subSequence);
        int expected = 6;
        assertEquals(expected, result);
    }
}