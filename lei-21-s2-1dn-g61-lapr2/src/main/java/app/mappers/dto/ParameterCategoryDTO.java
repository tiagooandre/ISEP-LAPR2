package app.mappers.dto;

/**
 * Creates a Data Transfer Object of the ParameterCategory class, used for listing categories
 * @author renan
 */
public class ParameterCategoryDTO {
    
    /**
     * code: The ParameterCategory's code
     */
    private final String code;
    /**
     * The ParameterCategory's description
     */
    private final String description;

    /**
     * Creates a ParameterCategoryDTO using the code and description from a ParameterCategory instance
     * 
     * @param code ParameterCategory's code
     * @param description ParameterCategory's description
     */
    public ParameterCategoryDTO(String code, String description) {
        this.code = code;
        this.description = description;
    }
    
    /**
     * Gets the code of a parameter category DTO
     * 
     * @return ParameterCategoryDTO's code
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Gets the description of a parameter category DTO
     * 
     * @return ParameterCategoryDTO's description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Writes the code and description of this ParameterCategoryDTO
     * 
     * @return a String with information related to this ParameterCategoryDTO
     */
    @Override
    public String toString() {
        return "ParameterCategory Code: " + this.code + "\nDescription: " + this.description;
    }
}