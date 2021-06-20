package app.mappers.dto;

/**
 * Creates a Data Transfer Object of the Parameter class, used for listing parameters
 * @author renan
 */
public class ParameterDTO {
    
    /**
     * code: The Parameter's code
     */
    private final String code;
    /**
     * The Parameter's description
     */
    private final String description;
    /**
     * The Parameter's category
     */
    private final String categoryDescription;

    /**
     * Creates a ParameterDTO using the code and description from a Parameter instance
     * 
     * @param code Parameter's code
     * @param description Parameter's description
     */
    public ParameterDTO(String code, String description, String categoryDescription) {
        this.code = code;
        this.description = description;
        this.categoryDescription = categoryDescription;
    }
    
    /**
     * Gets the code of a parameter DTO
     * 
     * @return ParameterDTO's code
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Gets the description of a parameter DTO
     * 
     * @return ParameterDTO's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the category of a parameter DTO
     *
     * @return ParameterDTO's category description
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * Writes the code and description of this ParameterDTO
     * 
     * @return a String with information related to this ParameterDTO
     */
    @Override
    public String toString() {
        return "Parameter Code: " + this.code + "\nDescription: " + this.description + "\nCategory Description: " + this.categoryDescription;
    }
}