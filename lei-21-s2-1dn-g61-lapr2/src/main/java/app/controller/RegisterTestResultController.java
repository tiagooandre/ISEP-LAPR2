/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.Test;
import app.domain.model.TestParameter;
import app.domain.model.TestStore;
import app.mappers.ParameterMapper;
import app.mappers.dto.ParameterDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan
 */
public class RegisterTestResultController {
    /**
     * The company that performs the tests
     */
    private final Company company;
    
    /**
     *  The Test being registered
     */
    private Test test;
    
    /**
     * The list of results
     */
    private List<TestParameter> testResults = new ArrayList<>();
    
    /**
     * Store containing all tests
     */
    private TestStore store;
    
    /**
     * Creates a controller getting the Company information from App
     */
    public RegisterTestResultController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }
    
    /**
     * Creates a controller from the Company, having it as a parameter
     * 
     * @param company The company responsible for performing the test
     */
    public RegisterTestResultController(Company company) {
        this.company = company;
        this.test = null;
    }
    
    /**
     * Gets a test based in the code introduced
     * 
     * @param code Test code
     * @return True if a test was found
     */
    public boolean getTest(String code){
        this.store = this.company.getTestStore();
        this.test=this.store.getTestByBarcode(code);
        return(this.test!=null);
    }
    
    /**
     * 
     * @return List of ParameterDTOs
     */
    public List<ParameterDTO> getParameters(){
        List<Parameter> parameters = this.test.getTestParameters();
        ParameterMapper pm = new ParameterMapper();
        return pm.parameterToDTO(parameters);
    }
    
    public void addResult(String code, String result, String metric) throws IOException {
        this.testResults.add(this.test.addTestResult(code, result, metric));
    }
    
    public String showIntrucedData(){
        StringBuilder result = new StringBuilder();
        
        for(TestParameter tp : this.testResults){
            result.append(tp.toString());
            result.append("\n\n");
        }
        
        return result.toString();
    }
    
    public boolean saveTestResult(){
        this.test.setResults(this.testResults);
        this.test.setDateChemAnalysis();
        this.test.setTimeChemAnalysis();

        return true;
    }
    
}
