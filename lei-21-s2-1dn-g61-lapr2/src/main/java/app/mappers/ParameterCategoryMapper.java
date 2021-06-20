package app.mappers;

import app.mappers.dto.ParameterCategoryDTO;
import app.domain.model.ParameterCategory;
import java.util.ArrayList;
import java.util.List;

/**
 * creates a list with ParameterDTO instances
 * 
 * @author renan
 */
public class ParameterCategoryMapper {
    
    /**
     * Converts a ParameterCategory instance into a TestTypeDTO one
     * 
     * @param pc The ParameterCategory to be converted
     * @return The convertedParameterCategoryDTO
     */
    public ParameterCategoryDTO toDTO(ParameterCategory pc) {
        return new ParameterCategoryDTO(pc.getCodePC(), pc.getDescriptionPC());
    }
    
    /**
     * Creates a ParameterDTO list from a Parameter list
     * 
     * @param testTypeCategories The list of Parameter instances to convert
     * @return The list of ParameterCategoryDTO instances
     */
    public List<ParameterCategoryDTO> parameterToDTO(List<ParameterCategory> testTypeCategories){
        List<ParameterCategoryDTO> parameterCategoryDTO = new ArrayList<>();
        for(ParameterCategory pc : testTypeCategories) {
            parameterCategoryDTO.add(this.toDTO(pc));
        }
        return parameterCategoryDTO;
    }
}