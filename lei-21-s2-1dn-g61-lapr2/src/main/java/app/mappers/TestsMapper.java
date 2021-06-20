package app.mappers;

import app.domain.model.Test;
import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestTypeDTO;

import java.util.ArrayList;
import java.util.List;

public class TestsMapper {

    /**
     * @param test The Test to be converted
     * @return The converted TestDTO
     */
    public TestDTO toDTO(Test test) {
        TestTypeDTO typedto = new TestTypeDTO(test.getTestType().getCode(), test.getTestType().getDescription(), test.getTestType().getMethods());
        ParameterMapper pm = new ParameterMapper();
        List<ParameterDTO> parametersDTO = pm.parameterToDTO(test.getTestParameters());

        return new TestDTO(test.getCode(), test.getNHScode(), test.getDescription(), typedto, test.getClient().getName(), parametersDTO);
    }

    /**
     * Creates a TestDTO list from a Test list
     *
     * @param tests The list of Test instances to convert
     * @return The list of TestDTO instances
     */
     public List<TestDTO> toDTO(List<Test> tests) {
        List<TestDTO> testsDTO = new ArrayList<>();
        for(Test test : tests) {
            //State 0 sample was not added
            if (test.checkTestState()==0) {
                testsDTO.add(this.toDTO(test));
            }
        }
        return testsDTO;
    }

    public List<TestDTO> toDTOCompleteTests(List<Test> tests) {
        List<TestDTO> testsDTO = new ArrayList<>();
        for(Test test : tests) {
                testsDTO.add(this.toDTO(test));
        }
        return testsDTO;
    }

}
