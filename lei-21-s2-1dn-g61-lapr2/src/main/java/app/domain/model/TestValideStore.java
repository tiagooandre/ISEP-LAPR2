package app.domain.model;

import java.util.List;
/**
 *
 * @author Miguel Chen
 */
public class TestValideStore {
    /**
     * List of Test
     */
    private final List<Test> testValideList;
    /**
     * Creates a validate test store that contains all validated tests
     *
     * @param testVlist The list containing test
     */
    public TestValideStore(List<Test> testVlist) {
        this.testValideList = testVlist;
    }
    /**
     * Validates the Validated test
     *
     * @param t The validated test to be validated
     * @return Validation if the validated test does not already exists
     */

    public boolean validateValide(Test t) {
        if (t == null)
            return false;
        return  ! this.testValideList.contains(t);
    }
    /**
     * Saves the validated test  if it is valid
     *
     * @param t The validated test to be added to the list of validated validated test
     * @return true if the new validated test was added successfully
     */
    public boolean addValide(Test t) {
        if (!validateValide(t)) {
            return false;
        }else {
            Client c = t.getClient();
            c.addTest(t);
            return this.testValideList.add(t);
        }
    }

    /**
     * Gets the number of covid positive tests in a specific date
     *
     * @param date The date
     * @return Number of positive cases
     */
    public int covidCasesPerDay(String date){
        int cases=0;
        for(Test t: this.testValideList){
            if(t.getDateRegistration().toYMDString().compareTo(date)==0 && t.getTestType().getCode().compareTo("tt001")==0){
                for(TestParameter tp : t.getResults()){
                    if(tp.getParameter().getCodeP().compareTo("IgGAN")==0 && stringToDouble(tp.getTestResult().getResult())>1.4){
                        cases++;
                    }
                }

            }
        }
        return cases;
    }
    /**
     * Gets the list of tests
     *
     * @return the list of test
     */
    public List<Test> getTestsValids(){
        List<Test> tests = null;
        tests = this.testValideList;
        return tests;
    }

    public double stringToDouble(String result){
        StringBuilder s= new StringBuilder();
        for(int i=0; i<result.length(); i++){
            if(result.charAt(i) == ',')
                s.append(".");
            else
                s.append(result.charAt(i));
        }
        return Double.parseDouble(s.toString());
    }
}



