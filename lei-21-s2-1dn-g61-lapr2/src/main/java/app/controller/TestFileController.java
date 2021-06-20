package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.domain.model.User;

import java.io.IOException;

import static java.lang.System.*;

/**
 * Controller for User Story 17
 * @author renan
 */
public class TestFileController {
    /**
     * The company that performs the tests
     */
    private final Company company;

    /**
     *  The Test being registered
     */
    private Test t;

    /**
     * The String[] with information for this test
     */
    private String[] testInfo;

    /**
     *  The TestStore used to create and save tests
     */
    private TestStore store;

    private static final String MESSAGE_SAMPLE = "Sample Date/Time: ";
    private static final String MESSAGE_PC002 = "pc002";
    private static final String MESSAGE_METRIC = "metric";
    private static final String MESSAGE_PARAMETER_INVALID = "Parameter invalid";

    /**
     * Creates a controller getting the Company information from App
     */
    public TestFileController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }

    /**
     * Creates a controller from the Company, having it as a parameter
     *
     * @param company The company responsible for performing the test
     */
    public TestFileController(Company company) {
        this.company = company;
        this.t = null;
    }

    /**
     * Gets information of a test from a CSV file
     *
     * @param f The file
     * @return String[] with information
     */
    public boolean getTestLine(String f, int i){
        CSVReader csv = new CSVReader();
        String[] line = csv.createTestFromFile(f, i);

        if(line==null)
            return false;
        this.testInfo = line;
        return true;
    }

    /**
     * Validates the nhs code from the file read
     *
     * Throws an exception if code is invalid
     */
    public void validCode(){
        this.store = this.company.getTestStore();
        if(this.store.getTestByNHS(this.testInfo[1])==null){
            this.t = new Test(this.testInfo[1]);
            this.t.setCode(this.testInfo[0]);
        }
        else
            throw new IllegalArgumentException("The nhs code is invalid");
    }

    /**
     * Validates the lab ID from the file read
     */
    public void validLab(){
        RegisterClinicalStore store7 = this.company.getRegisterClinicalStore();

        ClinicalAnalysisLaboratory lab = store7.getClinicById(this.testInfo[2]);
        if(lab!=null)
            lab.addTest(this.t);
        else
            throw new IllegalArgumentException("The lab is invalid");
    }

    /**
     * Validate the Client using its TIN from the file read
     *
     */
    public void validClient() throws IOException{
        RegisterClientStore store2 = this.company.getClientStore();

        Client c = store2.getClientByTIN(this.testInfo[5]);
        if(c!=null){
            this.t.setClient(c);
        }
        else{
                c = new Client(this.testInfo[8],
                        this.testInfo[3],
                        this.testInfo[6],
                        this.testInfo[4],
                        this.testInfo[5],
                        this.testInfo[9],
                        this.testInfo[7]);


            this.t.setClient(c);
            String p = GeneratePassword.generatePassword();
            User user=new User();
            if (this.company.getAuthFacade().addUserWithRole(c.getName(), c.getEmail(), p, Constants.ROLE_CLIENT)) {
                user.addUserMap(p, c);
                store2.saveClient(c);
            }
                sendEmail(c.getEmail(), p);
        }
    }

    /**
     * Validate the TestType using its code from the file read
     *
     */
    public void validTestType(){
        TestTypeStore store3 = this.company.getTestTypeStore();
        if(this.testInfo[11].compareTo("Covid")==0) {
            TestType tt = store3.getTestTypeById("tt001");
            this.t.setTestType(tt);
        }
        else if(this.testInfo[11].compareTo("Blood")==0) {
            TestType tt = store3.getTestTypeById("tt002");
            this.t.setTestType(tt);
        }
        else
            throw new IllegalArgumentException("The test type is invalid");
    }

    /**
     * Validate the ParameterCategory using its code from the file read
     *
     */
    public void validCategory(){
        ParameterCategoryStore store4 = this.company.getParameterCategoryStore();
        if(this.testInfo[12].compareTo("NA")!=0) {
            ParameterCategory pc = store4.getCategoryByCode(MESSAGE_PC002);
            this.t.setCategory(pc);
        }
        else if(this.testInfo[19].compareTo("NA")!=0) {
            ParameterCategory pc = store4.getCategoryByCode("pc001");
            this.t.setCategory(pc);
        }
        else
            throw new IllegalArgumentException("No valid category was found");
    }

    /**
     * Validate the Parameters using their code from the file read
     *
     */
    public void validParameter() throws IOException {
        ParameterStore store5 = this.company.getParameterStore();
        int valid=0;

        if(this.testInfo[13].compareTo("NA")!=0) {
            Parameter p = store5.getParameterByCode("HB000");
            if(this.t.getTestCategory().getCodePC().compareTo("pc002")==0) {
                this.t.addTestParameter(p);
                this.t.getResults().add(this.t.addTestResult("HB000", testInfo[13], "metric"));
            }
            else
                throw new IllegalArgumentException("Parameter invalid");
        }

        if(this.testInfo[14].compareTo("NA")!=0) {
            Parameter p = store5.getParameterByCode("WBC00");
            if(this.t.getTestCategory().getCodePC().compareTo(MESSAGE_PC002)==0) {
                this.t.addTestParameter(p);
                this.t.getResults().add(this.t.addTestResult("WBC00", testInfo[14], MESSAGE_METRIC));
                valid++;
            }
            else
                throw new IllegalArgumentException(MESSAGE_PARAMETER_INVALID);
        }

        if(this.testInfo[15].compareTo("NA")!=0) {
            Parameter p = store5.getParameterByCode("PLT00");
            if(this.t.getTestCategory().getCodePC().compareTo(MESSAGE_PC002)==0) {
                this.t.addTestParameter(p);
                this.t.getResults().add(this.t.addTestResult("PLT00", testInfo[15], MESSAGE_METRIC));
                valid++;
            }
            else
                throw new IllegalArgumentException(MESSAGE_PARAMETER_INVALID);
        }

        if(this.testInfo[16].compareTo("NA")!=0) {
            Parameter p = store5.getParameterByCode("RBC00");
            if(this.t.getTestCategory().getCodePC().compareTo(MESSAGE_PC002)==0) {
                this.t.addTestParameter(p);
                this.t.getResults().add(this.t.addTestResult("RBC00", testInfo[16], MESSAGE_METRIC));
                valid++;
            }
            else
                throw new IllegalArgumentException(MESSAGE_PARAMETER_INVALID);
        }

        if(this.testInfo[20].compareTo("NA")!=0) {
            Parameter p = store5.getParameterByCode("IgGAN");
            if(this.t.getTestCategory().getCodePC().compareTo("pc001")==0) {
                this.t.addTestParameter(p);
                this.t.getResults().add(this.t.addTestResult("IgGAN", testInfo[20], MESSAGE_METRIC));
                valid++;
            }
            else
                throw new IllegalArgumentException(MESSAGE_PARAMETER_INVALID);
        }

        if(valid==0)
            throw new IllegalArgumentException("No valid category was found");
    }

    /**
     * Creates time and date for the test in 22/03/2021 18:52 format
     */
    public void validDateTime(){
        this.t.setDateTimeAll(this.testInfo[21], this.testInfo[22], this.testInfo[23], this.testInfo[24]);
    }

    /**
     * Show the created test
     */
    public void showCreatedTest(){
        out.println(this.t);
        out.println("Client: " + this.t.getClient().getName());
        out.println("TestType: " + this.t.getTestType().getDescription());
        out.println("Category: " + this.t.getTestCategory().getDescriptionPC());
        out.println("Parameters: " + this.t.getTestParameters());
        out.println(MESSAGE_SAMPLE + this.t.getDateSample()+" "+this.t.getTimeSample());
        out.println(MESSAGE_SAMPLE + this.t.getDateChemAnalysis()+" "+this.t.getTimeChemAnalysis());
        out.println(MESSAGE_SAMPLE + this.t.getDateDiagnosis()+" "+this.t.getTimeDiagnosis());
        out.println(MESSAGE_SAMPLE + this.t.getDateValidTest().toYMDString()+" "+this.t.getTimeValidTest());
    }

    /**
     * Adds the test created from the CSV file
     *
     * @return true if the test was added
     */
    public boolean addCreatedTest(){
        if(this.testInfo[24].compareTo("NA")!=0) {
            this.store.saveTest(this.t);
            TestValideStore store6 = this.company.getValidationStore();
            return store6.addValide(this.t);
        }
        return false;
    }

    /**
     *sends email with the message
     * @param email The client's email
     * @throws IOException if file was invalid
     */
    public void sendEmail (String email, String p) throws IOException {
        String message =  "Hello. Your email is:"+ email +"\n" +
                "Your registration was successful and you can now start using the system.\n" +
                "Your password to login is as follows: " + p +"\n" +
                "Thank you, best regards.";
        EmailNotification.sendEmailToClient(message);
    }
}
