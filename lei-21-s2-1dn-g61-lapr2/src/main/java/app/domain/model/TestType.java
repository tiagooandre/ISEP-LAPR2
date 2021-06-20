package app.domain.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.controller.App;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents a test type and its information
 * 
 * @author renan
 */
public class TestType implements Serializable {
    /**
     * The test type's code
     */
    private String code;
    
    /**
     * The test type's description
     */
    private String description;
    
    /**
     * The test type's collecting methods
     */
    private String collectingMethods;
    
    /**
     * The parameters measured by this test type
     */
    private final List<ParameterCategory> testTypeCategories = new ArrayList<>();
    
    /**
     * Creates an instance of test type
     * 
     * @param code The description of the added test type
     * @param description The description of the added test type
     * @param collectingMethods How the samples are collected
     */
    public TestType(String code, String description, String collectingMethods){
        checkCodeRules(code);
        checkDescriptionRules(description);
        checkCollectingMethodsRules(collectingMethods);
        this.code = code;
        this.description = description;
        this.collectingMethods = collectingMethods;
    }

    
    /**
     * Check that code is not empty and contains 5 alphanumeric chars
     * 
     * @param code Code must have 1 to 15 chars
     */
    private void checkCodeRules(String code){
        if (code.length() != 5)
            throw new IllegalArgumentException("Code must have five alphanumeric characters.");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
    }
    /**
     * Check that description is not empty and contains 15 alphanumeric chars
     * 
     * @param description Description must have 1 to 15 chars
     */
    private void checkDescriptionRules(String description){
        if ((description.length()< 1) || (description.length()> 15))
            throw new IllegalArgumentException("Description must have 1 to 15 chars.");
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description cannot be blank.");
    }   
    /**
     * Check that collecting methods is not empty and contains 20 alphanumeric chars
     * 
     * @param collectingMethods Collecting methods must have 1 to 20 chars
     */
    private void checkCollectingMethodsRules(String collectingMethods) {
        if ((collectingMethods.length()< 1) || (collectingMethods.length()> 20))
            throw new IllegalArgumentException("Collecting Methods must have 1 to 20 chars.");
        if (StringUtils.isBlank(collectingMethods))
            throw new IllegalArgumentException("Collecting Methods cannot be blank.");
    }
    
    
    /**
     * Changes the test type code if it is valid
     * 
     * @param code New code for this test type
     */
    public void setCode(String code){
        checkCodeRules(code);
        this.code=code;
    }
    /**
     * Changes the test type description if it is valid
     * 
     * @param description New description for this test type
     */
    public void setDescription(String description){
        checkDescriptionRules(description);
        this.description=description;
    }
    /**
     * Changes the test type collecting methods if it is valid
     * 
     * @param cm New CollectingMethods for this test type
     */
    public void setMethods(String cm){
        checkCollectingMethodsRules(cm);
        this.collectingMethods=cm;
    }
    
    
    /**
     * Gets the test type code
     * 
     * @return This test type's code
     */
    public String getCode(){
        return this.code;
    }
    /**
     * Gets the test type description
     * 
     * @return This test type's description
     */
    public String getDescription(){
        return this.description;
    }
    /**
     * Gets the test type collecting methods
     * 
     * @return This test type's collecting methods
     */
    public String getMethods(){
        return this.collectingMethods;
    }
    /**
     * Gets the list of measured parameters of this test type
     * 
     * @return Parameters used in this test type
     */
    public List<ParameterCategory> getCategories(){
        return this.testTypeCategories;
    }
    /**
     * Adds a new parameter to be measured by the test type
     * 
     * @param pc The added parameter category for this test type
     */
    public void addTestTypeCategory(ParameterCategory pc){
        this.testTypeCategories.add(pc);
    }

    /**
     * Prints a string containing information concerning the test type
     * 
     * @return This parameter category's attributes information
     */
    @Override
    public String toString(){
        return String.format("Test Type #%s\n"
                + "Description: %s\n"
                + "Collecting methods: %s", this.code, this.description, this.collectingMethods);
    }

    /**
     * Gets an adapter for an API in order to get reference values, based on teh test type
     *
     * @return An external module, the adapter
     * @throws IOException In case configuration file is not found
     */
    public ExternalModule getExternalModule() throws IOException {
        ExternalModule em;
        switch(this.code){
            case "tt001":   em = new ExternalModuleAdapter1();
                            break;
                          
            case "tt002":   em = App.getBloodAPI();
                            break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.code);
        }
        return em;
    }
    
}