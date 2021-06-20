package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryStore;
import app.domain.model.TestType;
import app.domain.model.TestTypeStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for US 9: Create new Test Type
 * 
 * @author renan
 */
public class CreateTestTypeController {
    /**
     * The company that performs types of test
     */
    private Company company;
    
    /**
     * The test type being created
     */
    private TestType tt;
    
    /**
     * The store used to create and add test types
     */
    private TestTypeStore store;
    
    /**
     * The store used to access existing parameters
     */
    private ParameterCategoryStore store2;
    
    /**
     * Creates a controller getting the Company information from App
     */
    public CreateTestTypeController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }
    
    /**
     * Creates a controller from the Company, having it as a parameter
     * 
     * @param company The company responsible for knowing the test types
     */
    public CreateTestTypeController(Company company) {
        this.company = company;
        this.tt = null;
    }
    
    /**
     * Creates a test type based on information given by the UI
     * 
     * @param code The code of the added test type collected by the UI
     * @param description The description of the added test type collected by the UI
     * @param collectingMethods collecting methods for this test type collected by the UI
     * @return True if the new parameter category was added successfully to the company's database
     */
    public boolean createTestType(String code, String description, String collectingMethods) {
        this.store = this.company.getTestTypeStore(); 
        this.tt = this.store.createTestType(code, description, collectingMethods);
        return this.store.validateTestType(tt);
    }
    
    /**
     * Tells the test type store to save a test type
     * 
     * @return Validation if the test type does not already exists in the company
     */
    public boolean saveTestType() {
        return this.store.saveTestType(tt);
    }
    
    /**
     * Gets the list of test types known by the Company
     * 
     * @return All registered test types
     */
    public List<TestType> showAllTestTypes(){
        return new ArrayList<>(this.store.getTestTypes());
    }
    
    /**
     * Gets the list of parameters know by the Company
     * 
     * @return list of registered parameters 
     */
    public List<ParameterCategory> parameterCategoryList(){
        this.store2 = this.company.getParameterCategoryStore();
        return new ArrayList<>(this.store2.getParameterCategories());
    }
    
    /**
     * Adds a new parameter to the test type
     * 
     * @param pc Parameter category to be added
     */
    public void fillParameterCategoryList(ParameterCategory pc){
            this.tt.addTestTypeCategory(pc);
    }
}
