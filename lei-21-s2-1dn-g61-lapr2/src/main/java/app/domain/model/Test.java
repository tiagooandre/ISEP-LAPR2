package app.domain.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.apache.commons.lang3.StringUtils;

import static java.lang.Integer.*;
import static java.lang.System.*;

/**
 * Represents a test registered to be performed
 *
 * @author renan
 */
public class Test implements Comparable, Serializable {

    /**
     * testClient: The person to be be tested
     */
    private Client testClient;

    /**
     * testCode: The test's code
     */
    private String testCode;

    /**
     * testNHSID: The test's NHS id
     */
    private String testNHScode;

    /**
     * testTestType: The type of this test
     */
    private TestType testTestType;

    /**
     * testDecription: Information about collecting methods
     */
    private String testDescription;

    /**
     * testCategory: The test type's category analysed in this test
     */
    private ParameterCategory testCategory;

    /**
     * testParameters: The parameters to be measured in this test
     */
    private final List<Parameter> testParameters = new ArrayList<>();

    /**
     * testSamples: The samples associated to this test
     */
    private final List<Sample> testSamples = new ArrayList<>();

    /**
     * testResults: The parameter results associated to this test
     */
    private List<TestParameter> testResult = new ArrayList<>();

    /**
     * The day the sample was collected
     */
    private Date dateSample;

    /**
     * The day the chemical analysis was performed
     */
    private Date dateChemAnalysis;

    /**
     * The day the diagnosis was written
     */
    private Date dateDiagnosis;

    /**
     * The day the diagnosis was validated
     */
    private Date dateValidTest;

    /**
     * The day the test was made
     */
    private Date dateRegistration;

    /**
     * The time the sample was collected
     */
    private Time timeSample;

    /**
     * The time the chemical analysis was performed
     */
    private Time timeChemAnalysis;

    /**
     * The time the diagnosis was written
     */
    private Time timeDiagnosis;

    /**
     * The time the diagnosis was validated
     */
    private Time timeValidTest;

    /**
     * The time the test was made
     */
    private Time timeRegistration;

    /**
     * The test's report
     */
    private Report report;

    /**
     * Creates an instance of Test NHS code and a randomly generated code
     *
     * @param nh testNHCcode
     */
    public Test(String nh) {
        this.setNHScode(nh);
        this.setDateRegistration();
        this.setTimeRegistration();
    }

    /**
     * Generates a code composed of 12 random algorisms
     *
     * @return Test code
     */
    public String generateCode() {
        StringBuilder tc = new StringBuilder();
        Random val = new Random();

        for (int i = 0; i < 12; i++) {
            tc.append(val.nextInt(10));
        }
        return tc.toString();
    }

    /**
     * Sets a new test code if it is valid
     *
     * @param tc testCode
     */
    public final void setCode(String tc) {
        this.checkCodeRules(tc);
        this.testCode = tc;
    }

    /**
     * Gets the test's code
     *
     * @return the test's code
     */
    public String getCode() {
        return this.testCode;
    }

    /**
     * Validates a test code
     *
     * @param tc testCode
     */
    public void checkCodeRules(String tc) {
        if (tc.length() != 12)
            throw new IllegalArgumentException("Code must have 12 alphanumeric characters.");
        if (StringUtils.isBlank(tc))
            throw new IllegalArgumentException("Code cannot be blank.");
    }


    /**
     * Sets a new test NHS id if it is valid
     *
     * @param nh testNHSID
     */
    public final void setNHScode(String nh) {
        this.checkNHSRules(nh);
        this.testNHScode = nh;
    }

    /**
     * Gets the test's NHS id
     *
     * @return the test's NHS id
     */
    public String getNHScode() {
        return this.testNHScode;
    }

    /**
     * Validates a test NHS id
     *
     * @param nh testNHSID
     */
    public void checkNHSRules(String nh) {
        if (nh.length() != 12)
            throw new IllegalArgumentException("NHS code must have 12 alphanumeric characters.");
        if (StringUtils.isBlank(nh))
            throw new IllegalArgumentException("NHS code cannot be blank.");
    }

    /**
     * Sets this test's client
     *
     * @param c testClient
     */
    public void setClient(Client c) {
        this.testClient = c;
    }

    /**
     * Gets the test's client
     *
     * @return This test's client
     */
    public Client getClient() {
        return this.testClient;
    }

    /**
     * Sets this test's type of test
     *
     * @param tt testTestType
     */
    public void setTestType(TestType tt) {
        this.testDescription = tt.getMethods();
        this.testTestType = tt;
    }

    /**
     * Gets the test's type
     *
     * @return This test's type
     */
    public TestType getTestType() {
        return this.testTestType;
    }

    /**
     * Sets this test's measured parameter category
     *
     * @param pc testCategory
     */
    public void setCategory(ParameterCategory pc) {
        this.testCategory = pc;
    }

    /**
     * Gets the test's category
     *
     * @return This test's category
     */
    public ParameterCategory getTestCategory() {
        return this.testCategory;
    }

    /**
     * Adds a Parameter to the test's list of measured parameter
     *
     * @param p Parameter to be added
     */
    public void addTestParameter(Parameter p) {
        if (!this.testParameters.contains(p))
            this.testParameters.add(p);
    }

    /**
     * Gets this test's list of measured parameters
     *
     * @return test's list of parameters
     */
    public List<Parameter> getTestParameters() {
        return this.testParameters;
    }

    /**
     * Writes information about this test
     *
     * @return a string with information concerning the test
     */
    @Override
    public String toString() {
        return "Code: " + this.testCode + "\nNHS code: " + this.testNHScode;
    }

    /**
     * Sets the date when the sample was collected
     */
    public void setDateSample() {
        this.dateSample = new Date();
    }

    /**
     * Sets the date when the chemical analysis was performed
     */
    public void setDateChemAnalysis() {
        this.dateChemAnalysis = new Date();
    }

    /**
     * Sets the date when the diagnosis was written
     */
    public void setDateDiagnosis() {
        this.dateDiagnosis = new Date();
    }

    /**
     * Sets the date when the diagnosis was validated
     */
    public void setDateValidTest() {
        this.dateValidTest = new Date();
    }

    /**
     * Sets the date when the test was made
     */
    public void setDateRegistration() {
        this.dateRegistration = new Date();
    }

    /**
     * Gets the date when the test was made
     *
     * @return The date
     */
    public Date getDateRegistration() {
        return this.dateRegistration;
    }

    /**
     * Gets the date when the sample was recorded
     *
     * @return The date
     */
    public Date getRealDateSample() {
        return this.dateRegistration;
    }

    /**
     * Gets the date when the chemical analysis was performed
     *
     * @return The date
     */
    public Date getRealDateChemAnalysis() {
        return this.dateChemAnalysis;
    }

    /**
     * Gets the date when the diagnosis was written
     *
     * @return The date
     */
    public Date getRealDateDiagnosis() {
        return this.dateChemAnalysis;
    }

    /**
     * Gets the date when the sample was collected
     *
     * @return The date in YYYY/MM/DD format
     */
    public String getDateSample() {
        return this.dateSample.toYMDString();
    }

    /**
     * Gets the date when the chemical analysis was performed
     *
     * @return The date in YYYY/MM/DD format
     */
    public String getDateChemAnalysis() {
        return this.dateChemAnalysis.toYMDString();
    }

    /**
     * Gets the date when the diagnosis was written
     *
     * @return The date in YYYY/MM/DD format
     */
    public String getDateDiagnosis() {
        return this.dateDiagnosis.toYMDString();
    }

    /**
     * Gets the date when the diagnosis was validated
     *
     * @return The date in YYYY/MM/DD format
     */
    public Date getDateValidTest() {
        return this.dateValidTest;
    }

    /**
     * Sets the time when the sample was collected
     */
    public void setTimeSample() {
        this.timeSample = new Time();
    }

    /**
     * Sets the time when the chemical analysis was performed
     */
    public void setTimeChemAnalysis() {
        this.timeChemAnalysis = new Time();
    }

    /**
     * Sets the time when the diagnosis was performed
     */
    public void setTimeDiagnosis() {
        this.timeDiagnosis = new Time();
    }

    /**
     * Sets the time when the test was validated
     */
    public void setTimeValidTest() {
        this.timeValidTest = new Time();
    }

    /**
     * Sets the time when the test was made
     */
    public void setTimeRegistration() {
        this.timeRegistration = new Time();
    }

    /**
     * Gets the time when the test was made
     *
     * @return The time
     */
    public Time getTimeRegistration() {
        return this.timeRegistration;
    }

    /**
     * Gets the time when the sample was recorded
     *
     * @return The time
     */
    public Time getRealTimeSample() {
        return this.timeRegistration;
    }

    /**
     * Gets the time when the sample was collected
     *
     * @return The time in HH:MM:SS format
     */
    public String getTimeSample() {
        return this.timeSample.toString();
    }

    /**
     * Gets the time when the chemical analysis was performed
     *
     * @return The time in HH:MM:SS format
     */
    public String getTimeChemAnalysis() {
        return this.timeChemAnalysis.toString();
    }

    /**
     * Gets the time when the diagnosis was written
     *
     * @return The time in HH:MM:SS format
     */
    public String getTimeDiagnosis() {
        return this.timeDiagnosis.toString();
    }

    /**
     * Gets the time when the diagnosis was validated
     *
     * @return The time in HH:MM:SS format
     */
    public Time getTimeValidTest() {
        return this.timeValidTest;
    }

    /**
     * Sets this test's description
     *
     * @param testDescription testDescription
     */
    public void setDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    /**
     * Gets the test's description
     *
     * @return This test's description
     */
    public String getDescription() {
        return this.testDescription;
    }

    /**
     * Gets a parameter tested if there is one with a matching code
     *
     * @param parameterCode Code of the parameter
     * @return Null if no parameter has the introduced code, else it returns the parameter with the code introduced
     */
    public TestParameter getTestParameterFor(String parameterCode) {
        TestParameter result = null;
        for (Parameter p : this.getTestParameters()) {
            if (p.getCodeP().compareTo(parameterCode) == 0)
                result = new TestParameter(p);
        }
        return result;
    }

    /**
     * Gets the list of samples related to this Test
     *
     * @return The sample list
     */
    public List<Sample> getSamples() {
        return this.testSamples;
    }

    /**
     * Adds a test result for a parameter using an external API
     *
     * @param parameterCode The code's parameter
     * @param result        The parameter's result
     * @param metric        The metric used to measure the parameter
     * @return The test parameter, containing its results
     */
    public TestParameter addTestResult(String parameterCode, String result, String metric) throws IOException {
        TestParameter testParam = getTestParameterFor(parameterCode);
        Parameter param = testParam.getParameter();
        ExternalModule em = this.getTestType().getExternalModule();
        ReferenceValue refValue = em.getReferenceValue(param);
        testParam.addResult(result, metric, refValue);
        return testParam;
    }

    /**
     * Sets the results for this test
     *
     * @param tp List of parameter results
     */
    public void setResults(List<TestParameter> tp) {
        this.testResult = tp;
    }

    /**
     * Gets the results for this test
     *
     * @return List of parameter results
     */
    public List<TestParameter> getResults() {
        return this.testResult;
    }

    public Boolean createSample() {
        String numberBarcode;
        try {
            ExternalModuleBarcode gb = App.getBarcodeAPI();
            numberBarcode = gb.generateBarcode();
            Sample sample = new Sample(numberBarcode);

            return addSample(sample);

        } catch (OutputException | BarcodeException | IOException e) {
            out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Adds a sample to the Test' list
     *
     * @param sample The sample added
     */
    public Boolean addSample(Sample sample) {
        return this.testSamples.add(sample);
    }

    /**
     * Checks the Test state based on its dates
     *
     * @return State of the Test
     */
    public int checkTestState() {
        int state = 0;
        if (this.dateSample != null)
            state++;
        if (this.dateChemAnalysis != null)
            state++;
        if (this.dateDiagnosis != null)
            state++;
        if (this.dateValidTest != null)
            state++;
        return state;
    }

    public void setReport(Report r) {
        this.report = r;
    }

    public Report getReport() {
        return this.report;
    }

    /**
     * set for null validation date
     */
    public void setDateValidTestForNull() {
        this.dateValidTest = null;

    }

    /**
     * Compares tests using the serial test code
     *
     * @param o An object
     * @return A number used for sorting
     */
    public int compareTo(Object o) {
        Test t = (Test) o;
        return - (parseInt(this.testCode) - parseInt(t.testCode));
    }


    /**
     * set for null validation time
     */
    public void setTimeValidTestForNull() {
        this.timeValidTest = null;
    }

    /**
     * Sets all dates and times for a test
     *
     * @param d1 sample date and time
     * @param d2 analysis date and time
     * @param d3 report date and time
     * @param d4 validation date and time
     */
    public void setDateTimeAll(String d1, String d2, String d3, String d4){
        if(d1.compareTo("NA")!=0){
            this.dateRegistration = new Date(d1.substring(0, 10));
            this.dateSample = new Date(d1.substring(0, 10));
            this.timeRegistration = new Time(d1.substring(11));
            this.timeSample = new Time(d1.substring(11));
            this.createSample();
        }

        if(d2.compareTo("NA")!=0){
            this.dateChemAnalysis = new Date(d2.substring(0, 10));
            this.timeChemAnalysis = new Time(d1.substring(11));
        }
        else{
            this.testParameters.clear();
        }

        if(d3.compareTo("NA")!=0){
            this.dateDiagnosis = new Date(d3.substring(0, 10));
            this.timeDiagnosis = new Time(d1.substring(11));
            this.report = new Report("Report", new Diagnosis(this.testResult));
        }

        if(d4.compareTo("NA")!=0){
            this.dateValidTest = new Date(d4.substring(0, 10));
            this.timeValidTest = new Time(d1.substring(11));
        }
    }

    /**
     * Sets the date when the sample was collected
     */
    public void setDateSample(Date dateSample) {
        this.dateSample = dateSample;
    }

    /**
     * Sets the date when the chemical analysis was performed
     */
    public void setDateChemAnalysis(Date dateChemAnalysis) {
        this.dateChemAnalysis = dateChemAnalysis;
    }

    /**
     * Sets the date when the diagnosis was written
     */
    public void setDateDiagnosis(Date dateDiagnosis) {
        this.dateDiagnosis = dateDiagnosis;
    }

    /**
     * Sets the date when the diagnosis was validated
     */
    public void setDateValidTest(Date dateValidTest) {
        this.dateValidTest = dateValidTest;
    }

    /**
     * Sets the date when the test was made
     */
    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    /**
     * Sets the time when the sample was collected
     */
    public void setTimeSample(Time timeSample) {
        this.timeSample = timeSample;
    }

    /**
     * Sets the time when the chemical analysis was performed
     */
    public void setTimeChemAnalysis(Time timeChemAnalysis) {
        this.timeChemAnalysis = timeChemAnalysis;
    }

    /**
     * Sets the time when the diagnosis was performed
     */
    public void setTimeDiagnosis(Time timeDiagnosis) {
        this.timeDiagnosis = timeDiagnosis;
    }

    /**
     * Sets the time when the test was validated
     */
    public void setTimeValidTest(Time timeValidTest) {
        this.timeValidTest = timeValidTest;
    }

    /**
     * Sets the time when the test was made
     */
    public void setTimeRegistration(Time timeRegistration) {
        this.timeRegistration = timeRegistration;
    }
}