package app.mappers;

import app.mappers.dto.TestTypeDTO;
import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

/**
 * creates a list with TestTypeDTO instances
 * 
 * @author renan
 */
public class TestTypeMapper {
    
    /**
     * Converts a TestType instance into a TestTypeDTO one
     * 
     * @param tt The TestType to be converted
     * @return The converted TestTypeDTO
     */
    public TestTypeDTO toDTO(TestType tt) {
        return new TestTypeDTO(tt.getCode(), tt.getDescription(), tt.getMethods());
    }
    
    /**
     * Creates a TestTypeDTO list from a TestType list
     * 
     * @param testTypes The list of TestType instances to convert
     * @return The list of TestTypeDTO instances
     */
    public List<TestTypeDTO> testTypeToDTO(List<TestType> testTypes) {
        List<TestTypeDTO> testTypeDTO = new ArrayList<>();
        for(TestType tt : testTypes) {
            testTypeDTO.add(this.toDTO(tt));
        }
        return testTypeDTO;
    }
}
