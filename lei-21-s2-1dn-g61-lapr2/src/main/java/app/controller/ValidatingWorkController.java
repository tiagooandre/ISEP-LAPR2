package app.controller;

import app.domain.model.*;
import app.mappers.ValidTestMapper;
import app.mappers.dto.TestDateDTO;
import java.io.IOException;
import java.util.List;

import static java.lang.System.*;

/**
 *
 * @author Miguel Chen
 */
public class ValidatingWorkController {
    /**
     * the TestValideStore is used to validate and save the test
     */
    private TestValideStore store1;
    /**
     * the test store taht is used to fet the test list
     */
    private TestStore store;
    /**
     * the company that validates the work
     */
    private Company company;
    /**
     * the test that is validated
     */
    private Test t1;
    /**
     * the client which the test is corresponded
     */
    private Client cl;

    /**
     * Creates a controller getting the Company information from App
     */
    public ValidatingWorkController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
        this.store = this.company.getTest1Store();
        this.store1 = this.company.getValidationStore();
    }

    /**
     * Creates a controller from the Company, having it as a parameter
     * @param company
     */
    public ValidatingWorkController(Company company) {
        this.company = company;
    }

    /**
     *
     * Gets a DTO list of Test
     *
      @return A list with TestDateDTO

     */
    public  List<TestDateDTO> getTests() {
        List<Test> tests = this.store.getTests();
        ValidTestMapper tm = new ValidTestMapper();
        return tm.toDTO(tests);
    }

    /**
     *
     * gets test by using the code and gets client using this test
     * @param code
     */
    public void validateTest(String code)throws NullPointerException{
        this.t1 = store.getTestByCode(code);
        this.t1.setDateValidTest();
        this.t1.setTimeValidTest();
    }

    /**
     * eliminates the date and time validtion from test
     */
    public void eliminateTest(){
         this.t1.setDateValidTestForNull();
         this.t1.setTimeValidTestForNull();
    }
    /**
     * gets client using test
     * @return client
     * @throws NullPointerException
     */
    public Client getClient()throws NullPointerException{
        this.cl = this.t1.getClient();
        return cl;
    }

    /**
     * avalidates the test by setting the validation time and date also adds and saves the validated tests
     * @return true if the test was added to the list
     */
    public boolean addTest()  {
        this.store1 = this.company.getValidationStore();
        return this.store1.addValide(this.t1);
    }

    /**
     * sends email to teh client with the intructions
     * @throws IOException
     */
    public void sendMail (Client cl) throws IOException,NullPointerException {

        String message =  "Hello. " + cl.getName() + " your results are out you can check them in our website";
        EmailNotification.sendEmailToClient(message);
        out.println("Email sent");
    }

    /**
     * shows all the ativutes of the test
     * @return test code , nhs code, validation date and validation time
     */
    public String show(){
        return String.format("Test Code: %s\n"
                        + "NHS code: %s\n"
                        + "Validation date: %s\n"
                        + "Validation time: %s"
                , this.t1.getCode(), this.t1.getNHScode(), this.t1.getDateValidTest(), this.t1.getTimeValidTest());
    }

}

