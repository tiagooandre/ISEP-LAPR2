package app.mappers.dto;
/**
 *
 * @author Miguel Chen
 */
public class TestReporDTO {
    //code of the test
    private String testCode;

    /**
     * Creates a TestDateDTO using the test code , sample date, diagnosis date , chemical analysis date and their time from a Test instance
     *
     * @param code Test code


     */
    public TestReporDTO(String code) {
        this.testCode = code;


    }
    /**
     * Gets the test code of a test DTO
     *
     * @return TestDateDTO's code
     */
    public String getCode() {
        return testCode;
    }

    /**
     * Writes the test code, date of sample, date of diagnosis , date of chemical analysis and their time of this TestDateDTO
     *
     * @return a String with information related to this TestDateDTO
     */
    @Override
    public String toString() {
        return "TestReportDTO{" +
                "testCode='" + testCode ;
    }
}

