package app.mappers;

import app.domain.model.Test;
import app.mappers.dto.TestReporDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Chen
 */
public class TestReportMapper {
    /**
     * Creates a Test1DTO list from a Test list
     *
     * @param tests The list of Test instances to convert
     * @return The list of Test1DTO instances
     */
    public List<TestReporDTO> toDTO(List<Test> tests) {
        List<TestReporDTO> testReportDTO = new ArrayList<>();
        for(Test test : tests) {
            if(test.checkTestState()==2)
                testReportDTO.add(this.toDTO1(test));
        }
        return testReportDTO;
    }
    /**
     * Converts a Test instance if it contais the 3 dates (sample,chemAnalysis and diagnosis) into a Test1DTO one
     *
     * @param test The Test to be converted
     * @return The converted Test1DTO
     */
    TestReporDTO toDTO1(Test test) {
        return new TestReporDTO(test.getCode());
    }

}

