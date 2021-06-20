package app.mappers.dto;
/**
 *
 * @author Miguel Chen
 */
public class TestDateDTO  {
    //code of the test
    private String testCode;
    //diagnosis date
    private String dateDiagnosis;
    //chemical analysis date
    private String dateChemAnalysis;
    //sample date
    private String dateSample;
    //sample time
    private String timeSample;
    //diagnosis time
    private String timeDiagnosis;
    //chemAnalysis time
    private String timeChemAanalysis;

    /**
     * Creates a TestDateDTO using the test code , sample date, diagnosis date , chemical analysis date and their time from a Test instance
     *
     * @param code Test code
     * @param dateSample sample date
     * @param dateDiagnosis diagnosis date
     * @param dateChemAnalysis chemical analysis date

     */
    public TestDateDTO(String code, String dateSample ,String timeSample, String dateChemAnalysis,String timeChemAanalysis ,String dateDiagnosis, String timeDiagnosis) {
        this.testCode = code;
        this.dateChemAnalysis = dateChemAnalysis;
        this.timeSample = timeSample;
        this.timeChemAanalysis = timeChemAanalysis;
        this.timeDiagnosis = timeDiagnosis;
        this.dateDiagnosis = dateDiagnosis;
        this.dateSample = dateSample;

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
        return "TestDateDTO{" +
                "testCode='" + testCode + '\'' +
                ", dateDiagnosis='" + dateDiagnosis + '\'' +
                ", dateChemAnalysis='" + dateChemAnalysis + '\'' +
                ", dateSample='" + dateSample + '\'' +
                ", timeSample='" + timeSample + '\'' +
                ", timeDiagnosis='" + timeDiagnosis + '\'' +
                ", timeChemAanalysis='" + timeChemAanalysis + '\'' +
                '}';
    }
}