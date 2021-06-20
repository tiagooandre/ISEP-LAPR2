package app.domain.model;


import java.util.List;
/**
 * Stores, adds and manipulates test types
 *
 * @author renan
 */
public class TestTypeStore {
    /**
     * List of test types performed
     */
    private final List<TestType> testTypeList;
    
    /**
     * Creates a test type store that contains all test types registered
     * 
     * @param list The list containing the tests known by the Company
     */
    public TestTypeStore(List<TestType> list){
        this.testTypeList= list;
    }
     
    /**
     * Create an instance of test type by calling the test type constructor
     * 
     * @param code The code of the added test type
     * @param description The description of the added test type
     * @param collectingMethods Methods used to collect samples for this test
     * @return A new parameter category
     */
    public TestType createTestType(String code, String description, String collectingMethods) {
        return new TestType(code, description, collectingMethods);
    }
    
    /**
     * Validates the created test type
     * 
     * @param tt The test type to be validated
     * @return Validation if the test type does not already exists
     */
    public boolean validateTestType(TestType tt) {
        if (tt == null)
            return false;
        return ttExists(this.testTypeList, tt);
    }
    
    /**
     * Saves the test type if it is valid
     * 
     * @param tt The test type to be added to the list of parameter categories
     * @return true if the new test type was added successfully
     */
    public boolean saveTestType(TestType tt) {
        if (!validateTestType(tt))
            return false;
        else
            return this.testTypeList.add(tt);
    }
    
    /**
     * Checks if the test type code is valid for creation
     * 
     * @param list List containing all known test types
     * @param tt The test to be validated
     * @return true if the test code is not already registered
     */
    public boolean ttExists(List<TestType> list, TestType tt){
        for(TestType t : list){
            if(t.getCode().compareTo(tt.getCode())==0)
                return false;
        }
        return true;
    }
    
    /**
     * Returns the list of test types
     * 
     * @return the list of test types
     */
    public List<TestType> getTestTypes(){
        return this.testTypeList;
    }
    
    /**
     * Get a test type by its code
     * 
     * @param ttCode The Test type code
     * @return The test type
     */
    public TestType getTestTypeById(String ttCode){
        TestType tt = null;
        for(TestType testT : this.testTypeList){
            if(testT.getCode().compareTo(ttCode)==0)
                tt = testT;
        }
        return tt;
    }
    
}
