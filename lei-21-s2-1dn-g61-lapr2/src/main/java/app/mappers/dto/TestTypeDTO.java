package app.mappers.dto;

/**
 * Creates a Data Transfer Object of the TestType class, used for listing known test types
 * @author renan
 */
public class TestTypeDTO {
    
    /**
     * code: The TestType's code
     */
    private final String code;
    /**
     * The TestType's description
     */
    private final String description;
    /**
     * The test type's collecting methods
     */
    private String collectingMethods;

    /**
     * Creates a TestTypeDTO using the code and description from a TestType instance
     * 
     * @param code TestType's code
     * @param description TestType's description
     */
    public TestTypeDTO(String code, String description, String collectingMethods) {
        this.code = code;
        this.description = description;
        this.collectingMethods = collectingMethods;
    }
    
    /**
     * Gets the code of a test type DTO
     * 
     * @return TestTypeDTO's code
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Gets the description of a test type DTO
     * 
     * @return TestTypeDTO's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the collecting methods of a test type DTO
     *
     * @return TestTypeDTO's collectingMethods
     */
    public String getCollectingMethods() {
        return collectingMethods;
    }

    /**
     * Writes the code and description of this TestTypeDTO
     * 
     * @return a String with information related to this TestTypeDTO
     */
    @Override
    public String toString() {
        return "TestType Code: " + this.code + "\nDescription: " + this.description;
    }
}