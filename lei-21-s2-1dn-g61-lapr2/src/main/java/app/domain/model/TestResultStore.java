package app.domain.model;

import java.util.List;

public class TestResultStore {

    private List<TestParameter> resultlist;

    public TestResultStore(List<TestParameter> resultList) {
        this.resultlist = resultList;
    }

    public boolean validateResults(List<TestParameter> resultlist){

        for (TestParameter result : resultlist){
            double max = result.getTestResult().getRefValue().getMaxRefVal();
            double min = result.getTestResult().getRefValue().getMinRefVal();

            double r = Double.parseDouble(result.getTestResult().getResult());
            if ( r > max || r < min) {
                return false;
            }
        }
        return true;
    }

}
