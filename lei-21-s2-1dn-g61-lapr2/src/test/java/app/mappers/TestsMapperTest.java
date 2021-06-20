package app.mappers;

import app.domain.model.Client;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.dto.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestsMapperTest {

    /**
     * Test of toDTO(Test test) method, of class TestsMapper.
     */
    @Test
    public void toDTO() {
        System.out.println("Create testDTO");
        String nh = "123456789012";
        String description = "test";
        app.domain.model.Test t = new app.domain.model.Test(nh);
        t.setDescription(description);
        TestType tt = new TestType("tt009", "Urine", "123456");
        t.setTestType(tt);
        ParameterCategory pc = new ParameterCategory("toSOS", "Patê", "id21");
        Parameter p = new Parameter("2121", "toSOS", pc);
        t.addTestParameter(p);
        Client c = new Client("João de Alburquerque","1234567890123256","02/11/2001", "1221567890", "1221267890","cliente2@geeksforgeeks.org","21212121333","Non Binary");
        t.setClient(c);
        TestTypeDTO typedto = new TestTypeDTO(t.getTestType().getCode(), t.getTestType().getDescription(), t.getTestType().getMethods());
        ParameterMapper pm = new ParameterMapper();
        List<ParameterDTO> parametersDTO = pm.parameterToDTO(t.getTestParameters());
        TestDTO expected = new TestDTO(t.getCode(), t.getNHScode(), t.getDescription(), typedto, t.getClient().getName(), parametersDTO);
        TestsMapper tm = new TestsMapper();

        TestDTO result = tm.toDTO(t);
        assertEquals(expected.toString(),result.toString());
    }

    /**
     * Test of toDTO(List<Test> tests) method, of class TestsMapper.
     */
    @Test
    public void testToDTO() {
        System.out.println("Create list testsDTO");

        String nh = "123456789012";
        String description = "test";
        app.domain.model.Test t = new app.domain.model.Test(nh);
        t.setDescription(description);
        TestType tt = new TestType("tt009", "Urine", "123456");
        t.setTestType(tt);
        ParameterCategory pc = new ParameterCategory("toSOS", "Patê", "id21");
        Parameter p = new Parameter("2121", "toSOS", pc);
        t.addTestParameter(p);
        Client c = new Client("João de Alburquerque","1234567890123256","02/11/2001", "1221567890", "1221267890","cliente2@geeksforgeeks.org","21212121333","Non Binary");
        t.setClient(c);

        TestsMapper tm = new TestsMapper();
        List<app.domain.model.Test> tests = new ArrayList<>();
        tests.add(t);


        List<TestDTO> testsDTOexpect = new ArrayList<>();
        List<TestDTO> testsDTOresult = tm.toDTO(tests);

        TestTypeDTO typedto = new TestTypeDTO(t.getTestType().getCode(), t.getTestType().getDescription(), t.getTestType().getMethods());
        ParameterMapper pm = new ParameterMapper();
        List<ParameterDTO> parametersDTO = pm.parameterToDTO(t.getTestParameters());


        TestDTO testDTO = new TestDTO(t.getCode(), t.getNHScode(), t.getDescription(), typedto, t.getClient().getName(), parametersDTO);
        testsDTOexpect.add(testDTO);
        String expected = testsDTOexpect.toString();
        String result = testsDTOresult.toString();
        assertEquals(expected,result);
    }
}