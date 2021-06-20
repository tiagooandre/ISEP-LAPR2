package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryStore;
import app.domain.model.ParameterStore;
import app.domain.model.RegisterClientStore;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.domain.model.TestType;
import app.domain.model.TestTypeStore;
import app.mappers.ParameterCategoryMapper;
import app.mappers.ParameterMapper;
import app.mappers.TestTypeMapper;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestTypeDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for US 4: Register new Test
 * 
 * @author renan
 */
public class RegisterTestController {    
    /**
     * The company that performs the tests
     */
    private final Company company;
    
    /**
     *  The Test being registered
     */
    private Test t;
    
    /**
     * The parameter category measured in this test
     */
    private ParameterCategory cat;
    
    /**
     *  The TestStore used to create and save tests
     */
    private TestStore store;
    
    /**
     * The RegisterClientStore used to check the registered clients
     */
    private RegisterClientStore store2;
    
    /**
     * The TestTypeStore used to check the registered test types and their categories
     */
    private TestTypeStore store3;
    
    /**
     * The ParameterCategoryStore used to check the registered categories and their parameters
     */
    private ParameterCategoryStore store4;
    
    /**
     * The ParameterStore used to check the registered parameters
     */
    private ParameterStore store5;
    
    /**
     * Creates a controller getting the Company information from App
     */
    public RegisterTestController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }
    
    /**
     * Creates a controller from the Company, having it as a parameter
     * 
     * @param company The company responsible for performing the test
     */
    public RegisterTestController(Company company) {
        this.company = company;
        this.t = null;
    }
    
    /**
     * Creates a test based on information given by the UI
     * 
     * @param testNHScode The NHS code of the added test collected by the UI
     * @param clientTINid The TIN id of the tested client, collected by the UI
     * @return True if the new test was added successfully to the company's database
     */
    public boolean createTest(String testNHScode, String clientTINid) {
        this.store = this.company.getTestStore();
        this.t = this.store.createTest(testNHScode);
        this.t.setCode(this.generateCode());
        
        if(!this.newTest())
            return false;
        
        this.store2 = this.company.getClientStore();
        Client c = this.store2.getClientByTIN(clientTINid);
        if(c==null)
            return false;
        this.t.setClient(c);
        return true;
    }
    
    /**
     * Tells the test store to save a test
     * 
     * @return Validation if the test type does not already exists in the company
     */
    public boolean saveTest() {
        return this.store.saveTest(t);
    }
    
    /**
     * Gets the list of registered clients
     * 
     * @return The list of clients
     */
    public List<Client> getClients(){
        this.store2 = this.company.getClientStore();
        return new ArrayList<>(this.store2.getClients());
    }
    
    /**
     * Sets the client who will be tested
     * 
     * @param nhsId Client's NHS id
     * @return True if a client was found, false if not
     */
    public boolean setClient(String nhsId){
        this.store2 = this.company.getClientStore();
        Client c =this.store2.getClientByTIN(nhsId);
        if(c!=null){
            this.t.setClient(c);
            return true;
        }
        else
            return false;
    }
    
    /**
     * Gets the list of test types known by the Company
     * 
     * @return All registered test types
     */
    public List<TestType> showAllTestTypes(){
        this.store3 = this.company.getTestTypeStore();
        return new ArrayList<>(this.store3.getTestTypes());
    }
    
    /**
     * Sets the type of test to be performed
     * 
     * @param ttCode Test Type code
     * @return True if a test type was set, false if no test type was found
     */
    public boolean setTestsType(String ttCode){
        TestType tt = this.store3.getTestTypeById(ttCode);
        if(tt == null)
            return false;
        else{
            this.t.setTestType(tt);
            return true;
        }
    }
    
    /**
     * Sets the category to be tested
     * 
     * @param pcCode Category code
     * @return True if a category was set, false if no category was found
     */
    public boolean setCategory(String pcCode){
        ParameterCategory pc = this.store4.getCategoryByCode(pcCode);
        if(pc == null)
            return false;
        else{
            this.t.setCategory(pc);
            this.cat = pc;
            return true;
        }
    }
    
    /**
     * Adds a parameter to be tested
     * 
     * @param pCode Parameter code
     * @return True if a parameter was added, false if no parameter was found
     */
    public boolean addParameter(String pCode){
        this.store5 = this.company.getParameterStore();
        Parameter p = this.store5.getParameterByCode(pCode);
        if(p == null)
            return false;
        else{
            this.t.addTestParameter(p);
            return true;
        }
    }
    
    /**
     * Gets the list of parameters measured by the TestType
     * 
     * @return list of registered parameters of the test type
     */
    public List<ParameterCategory> parameterCategoryList(){
        return new ArrayList<>(this.t.getTestType().getCategories());
    }
    
    /**
     * Adds a new parameter to the test
     * 
     * @param p Parameter to be added
     */
    public void fillParameterList(Parameter p){
            this.t.addTestParameter(p);
    }
    
    /**
     * Gets a DTO list of TestTypes
     * 
     * @return A list with TestTypeDTOs
     */
    public List<TestTypeDTO> getTestTypes(){
        this.store3 = this.company.getTestTypeStore();
        List<TestType> testTypes = this.store3.getTestTypes();
        TestTypeMapper ttm = new TestTypeMapper();
        return ttm.testTypeToDTO(testTypes);
    }
    
    /**
     * Gets a DTO list of ParameterCategory
     * 
     * @return A list with ParameterCategoryDTOs
     */
    public List<ParameterCategoryDTO> getCategories(){
        this.store4 = this.company.getParameterCategoryStore();
        List<ParameterCategory> testTypeCategories = this.t.getTestType().getCategories();
        ParameterCategoryMapper pcm = new ParameterCategoryMapper();
        return pcm.parameterToDTO(testTypeCategories);
    }
    
    /**
     * Gets a DTO list of Parameter
     * 
     * @return A list with ParameterDTOs
     */
    public List<ParameterDTO> getParameters(){
        List<Parameter> parameters = this.cat.getParameters();
        ParameterMapper pm = new ParameterMapper();
        return pm.parameterToDTO(parameters);
    }
    
    /**
     * Shows created data
     * 
     * @return String containing all information concerning the created test
     */
    public String showIntrucedData(){
        return String.format("Test Code: %s\n"
                           + "NHS code: %s\n"
                           + "Client's name: %s\n"
                           + "TestType: %s\n"
                           + "Category: %s\n"
                           + "Parameters: %s"
                           , this.t.getCode(), this.t.getNHScode(), this.t.getClient().getName(), this.t.getTestType().getDescription(), this.t.getTestCategory().getDescriptionPC(), this.t.getTestParameters());
    }

    /**
     * Checks if there is a test with teh same NHS code
     *
     * @return True if NHS code is new, False if not
     */
    public boolean newTest(){
        for(Test test : this.store.getTests()){
            if(test.getNHScode().compareTo(this.t.getNHScode())==0)
                return false;
        }
        return true;
    }
    
    public String generateCode(){
        return this.store.generateCode();
    }
}
