package app.controller;

import app.domain.model.*;
import app.mappers.TestsMapper;
import app.mappers.dto.TestDTO;

import java.io.IOException;
import java.util.*;

public class ViewClientResultsController {

    /**
     * The company that knows the tests
     */
    private final Company company;

    /**
     * Client who do the test
     */
    private Client client;

    /**
     * The client store to get the client
     */
    private RegisterClientStore cStore;

    /**
     * The test store to get the test chosen by client
     */
    private TestStore testStore;

    /**
     * Creates a controller getting the Company information from App
     */
    public ViewClientResultsController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }


    public ViewClientResultsController(Company company) {
        this.company = company;
    }

    public String getEamilOfClient() {
        return this.company.getAuthFacade().getCurrentUserSession().getUserId().toString();
    }

    /**
     * this method return client by email
     *
     * @return client by email
     */
    public Client getClientByEmail() {
        String email = getEamilOfClient();
        this.cStore = this.company.getClientStore();
        return this.cStore.getClientByEmail(email);
    }

    /**
     * this method give us the test complete for this client
     *
     * @return list of test dto from client
     */
    public List<TestDTO> getTestsDTOCompleteForThisClient() {
        this.client = getClientByEmail();
        List<Test> tests = this.client.getLstTestComplete();
        TestsMapper tm = new TestsMapper();
        return tm.toDTOCompleteTests(tests);
    }


    /**
     * this method gets the lists of tests ordered
     *
     * @param testDTOS list of tests dto
     * @return list of test ordered
     */
    public List<Test> getTestsOrdered(List<TestDTO> testDTOS) {
        List<Test> lstTestsOrdered = new ArrayList<>();
        this.testStore = this.company.getTestStore();

        for (TestDTO testDTO : testDTOS) {
            lstTestsOrdered.add(this.testStore.getTestByCode(testDTO.getCode()));
        }

        Collections.sort(lstTestsOrdered);

        return lstTestsOrdered;
    }

    /**
     * this method return a test by a code
     *
     * @param nhsCode test´s nhs code
     * @return test
     */
    public Test getTestByNhsCode(String nhsCode) {
        this.testStore = this.company.getTestStore();
        return this.testStore.getTestByNHS(nhsCode);
    }

    /**
     * this method give us the results for this test
     *
     * @param t client´s test
     * @return list of parameters
     */
    public List<TestParameter> getResultsForThisTest(Test t) {
        return t.getResults();
    }

    public Report getReport(Test t){
        return t.getReport();
    }

}