package app.domain.model;

import java.util.List;
/**
 * Store used to add test and manipulate registered ones
 * 
 * @author renan
 */
public class TestStore {
    /**
     * List of tests registered 
     */
    private final List<Test> testList;
    
    /**
     * Creates a test type store that contains all test types registered
     * 
     * @param list The list containing the tests known by the Company
     */
    public TestStore(List<Test> list){
        this.testList= list;
    }
     
    /**
     * Create an instance of test by calling the test constructor
     * 
     * @param testNHScode NHS code associated to the added test
     * @return A new parameter category
     */
    public Test createTest(String testNHScode) {
        return new Test(testNHScode);
    }
    
    /**
     * Validates the created test
     * 
     * @param t The test to be validated
     * @return Validation if the test does not already exists
     */
    public boolean validateTest(Test t) {
        if (t == null)
            return false;
        return tExists(this.testList, t);
    }
    
    /**
     * Saves the test if it is valid
     * 
     * @param t The test to be added to the list of tests
     * @return true if the new test was added successfully
     */
    public boolean saveTest(Test t) {
        if (!validateTest(t))
            return false;
        else
            return this.testList.add(t);
    }
    
    /**
     * Checks if the test code is valid for creation
     * 
     * @param list List containing all known tests
     * @param t The test to be validated 
     * @return true if the test code is not already registered
     */
    public boolean tExists(List<Test> list, Test t){
        for(Test test : list){
            if(test.getCode().compareTo(t.getCode())==0)
                return false;
        }
        return true;
    }
    
    /**
     * Gets the list of tests
     * 
     * @return the list of test
     */
    public List<Test> getTests(){
        List<Test> tests = null;
        tests = this.testList;
        return tests;
    }
    /**
     * Get a test by its test code
     *
     * @param code The Test code
     * @return The test if it was found, null if not
     */
    public Test getTestByCode(String code){
        for(Test test : this.testList){
            if(test.getCode().compareTo(code)==0)
                return test;
        }
        return null;
    }

    /**
     * Gets a test from a sample's barcode
     *
     * @param barcode The sample's barcode
     * @return The test with the desired sample
     */
    public Test getTestByBarcode(String barcode){
        for(Test t : this.testList){
            for(Sample s : t.getSamples()){
                if(s.getBarcode().compareTo(barcode)==0)
                    return t;
            }
        }
        return null;
    }

    /**
     * Gets a test from a nhs code
     *
     * @param nhs The sample's nhs code
     * @return The test with the desired nhs code
     */
    public Test getTestByNHS(String nhs){
        for(Test t : this.testList){
            if(t.getNHScode().compareTo(nhs)==0)
                return t;
        }
        return null;
    }

    /**
     * Generates the serial code of the test
     *
     * @return The serial code
     */
    public String generateCode(){
        int codeNum = this.testList.size()+1;
        return String.format("%012d", codeNum);
    }


}