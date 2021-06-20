package app.mappers.dto;

import java.util.List;

public class TestDTO {
    //code of the test
    private String testCode;
    //NHScode of the test
    private String testNHSCode;
    //Description of the test
    private String testDescription;
    //The typeDTO of this test
    private TestTypeDTO testTypeDTO;
    //The client associated to this test
    private String testClientName;
    //The list of ParameterDTO associated to this test
    private List<ParameterDTO> parametersDTO;

    /**
     * Creates a TestDTO using the test code, test NHS code and test description from a Test instance
     *
     * @param code Test code
     * @param nhscode Test NHS code
     * @param description Test description
     */
    public TestDTO(String code, String nhscode ,String description, TestTypeDTO testType, String clientName, List<ParameterDTO> parametersDTO) {
        this.testCode = code;
        this.testNHSCode = nhscode;
        this.testDescription = description;
        this.testTypeDTO = testType;
        this.testClientName = clientName;
        this.parametersDTO = parametersDTO;
    }

    /**
     * Gets the test code of a test DTO
     *
     * @return TestDTO's code
     */
    public String getCode() {
        return testCode;
    }

    /**
     * Gets the list with all parametersDTO of a test DTO
     *
     * @return list with all parametersDTO associated to the testDTO
     */
    public List<ParameterDTO> getParameters() {
        return parametersDTO;
    }

    /**
     * Writes the test code, the test NHSCode and the test description
     *
     * @return a String with information related to this TestDTO
     */
    @Override
    public String toString() {
        String description = "Description = ";
        String code = "Code = ";
        return "Test:   " +
                code + testCode + "   " +
                "NHS Code = " + testNHSCode + "   " +
                description + testDescription + "\n" +
                "    Test Type:   " +
                code + testTypeDTO.getCode() + "   " +
                description + testTypeDTO.getDescription() + "   " +
                "Collect method = " + testTypeDTO.getCollectingMethods() + "\n" +
                "    Client:   " +
                "Name = " + testClientName;
    }

    /**
     * Writes the information about all parametersDTO in in test
     *
     * @return a String with information related to this ParametersDTO
     */
    public String toStringParameterDTO(ParameterDTO parameterDTO) {
        return "    Parameters =   " +
                "Code = " + parameterDTO.getCode() + "   " +
                "Description = " + parameterDTO.getDescription() + "   " +
                "Category description = " + parameterDTO.getCategoryDescription() + "\n";
    }

}
