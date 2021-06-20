/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.model.*;
import app.mappers.TestReportMapper;
import app.mappers.dto.TestReporDTO;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Gon�alo
 */
public class MakeReportController {
    
    private Company company;
    private Report r;
    private ReportStore reportStore;
    private TestStore testStore;
    private Test t2 ;
    private Client testClient;
    private TestResultStore trs;
    private Diagnosis diagnosis;

    public MakeReportController() throws IOException, ClassNotFoundException {

        this(App.getInstance().getCompany());
        this.testStore = this.company.getTestStore();
        this.reportStore = this.company.getReportStore();
    }
    
    /**
     * @param company The company responsible for knowing the reports
     */
    public MakeReportController(Company company){

        this.company = company;
        this.r = null;
    }
    /**
     *
     * Gets a DTO list of Test
     *
     @return A list with TestReporDTO
     */
    public  List<TestReporDTO> getTests() {
        List<Test> tests = this.testStore.getTests();
        TestReportMapper tm = new TestReportMapper();
        return tm.toDTO(tests);
    }
    /**
     *
     * this method gives us the test that has that code coming from the dto
     * @param code the code that identifies the test
     * @return test the test that is identified by the code
     */
    public Test getTest(String code){
        this.t2 = this.testStore.getTestByCode(code);
        return this.t2;
    }
    /**
     *
     * Gets the results of this test
     * @return A list with
     */
    public List<TestParameter>  getResultsforthisTest(){
        return this.t2.getResults();
    }
    /**
     *
     * this method will validate results with a external module
     * @return true if validation it´s successful, false if it´s not been validate
     */
    public boolean validateResults(){
        List<TestParameter> testResult = getResultsforthisTest();
        this.trs = this.company.getTestResultStore();
        return this.trs.validateResults(testResult);
    }
    /**
     *
     * this create a diagnosis with a results from one test
     *
     * @return diagnosis created with results from test
     */
   public Diagnosis createDiagnosis(){
        this.reportStore = this.company.getReportStore();
        List<TestParameter> testResult = getResultsforthisTest();
        this.diagnosis = new Diagnosis(testResult);
        return this.diagnosis;
   }

    /**
     *
     * this method will get a client from a test
     *
     * @return client from one test
     */

   public Client getTestClient(){
        this.testClient = this.t2.getClient();
        return testClient;
    }
    /**
     * @param text The text written to describe the test done
     * @param diagnosis The diagnosis that is within the report 
     * @return True if the new report was added successfully to the company's database
     */
    public boolean createReport(String text, Diagnosis diagnosis){
        this.reportStore = this.company.getReportStore();
        this.r = this.reportStore.createReport(text, diagnosis);
        return this.reportStore.validateReport(r);
    }
    
    /**
     * @return Validation if the report does not alraedy exists 
     */
    public boolean saveReport(){
        this.t2.setDateDiagnosis();
        this.t2.setTimeDiagnosis();
        this.t2.setReport(r);
        return this.reportStore.saveReport(r);
    }

    public Test getTest(){
        return this.t2;
    }


 
}
