package app.mappers;

import app.domain.model.Test;
import app.mappers.dto.TestDateDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Chen
 */

public class ValidTestMapper {
    /**
     * Creates a Test1DTO list from a Test list
     *
     * @param tests The list of Test instances to convert
     * @return The list of Test1DTO instances
     */
    public List<TestDateDTO> toDTO(List<Test> tests) throws NullPointerException{
        List<TestDateDTO> testDateDTO = new ArrayList<>();
        for(Test t1 : tests) {
            if(t1.checkTestState()==3)
                testDateDTO.add(this.toDTO1(t1));
        }
        return testDateDTO;
    }
    /**
     * Converts a Test instance if it contais the 3 dates (sample,chemAnalysis and diagnosis) into a Test1DTO one
     *
     * @param test The Test to be converted
     * @return The converted Test1DTO
     */
    TestDateDTO toDTO1(Test test) {
         return new TestDateDTO(test.getCode(),test.getDateSample(), test.getTimeSample(), test.getDateChemAnalysis(),test.getTimeChemAnalysis(),test.getDateDiagnosis(),test.getTimeDiagnosis());
    }

}