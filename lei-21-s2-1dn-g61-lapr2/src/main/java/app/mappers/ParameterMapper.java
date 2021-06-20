package app.mappers;

import app.mappers.dto.ParameterDTO;
import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * creates a list with ParameterDTO instances
 * 
 * @author renan
 */
public class ParameterMapper {
    
    /**
     * Converts a TestType instance into a TestTypeDTO one
     * 
     * @param p The Parameter to be converted
     * @return The convertedParameterDTO
     */
    public ParameterDTO toDTO(Parameter p) {
        return new ParameterDTO(p.getCodeP(), p.getDescriptionP(), p.getCategoryP().getDescriptionPC());
    }
    
    /**
     * Creates a ParameterDTO list from a Parameter list
     * 
     * @param parameters The list of Parameter instances to convert
     * @return The list of ParameterDTO instances
     */
    public List<ParameterDTO> parameterToDTO(List<Parameter> parameters) {
        List<ParameterDTO> parameterDTO = new ArrayList<>();
        for(Parameter p : parameters) {
            parameterDTO.add(this.toDTO(p));
        }
        return parameterDTO;
    }
}