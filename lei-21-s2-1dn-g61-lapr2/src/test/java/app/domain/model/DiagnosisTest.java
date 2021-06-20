package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiagnosisTest {

    @Test
    public void getList(){
        Parameter parameter = new Parameter("12340", "iuytdxgf", new ParameterCategory("12345", "uiytghvjb", "87654"));
        TestParameter testParameter1 = new TestParameter(parameter);
        Parameter parameter2 = new Parameter("09840", "ergdfxgf", new ParameterCategory("34521", "dfghngb", "895654"));
        TestParameter testParameter2= new TestParameter(parameter2);
        Parameter parameter3 = new Parameter("45340", "wergth", new ParameterCategory("12985", "werghnb", "29654"));
        TestParameter testParameter3 = new TestParameter(parameter3);

        List<TestParameter> testParameters = new ArrayList<>();
        testParameters.add(testParameter1);
        testParameters.add(testParameter3);
        testParameters.add(testParameter2);

        Diagnosis diagnosis = new Diagnosis(testParameters);

        assertEquals(testParameters, diagnosis.getList());

    }

    @Test
    public void testToString() {
        System.out.println("toString()");

        Parameter parameter = new Parameter("12340", "iuytdxgf", new ParameterCategory("12345", "uiytghvjb", "87654"));
        TestParameter testParameter1 = new TestParameter(parameter);
        Parameter parameter2 = new Parameter("09840", "ergdfxgf", new ParameterCategory("34521", "dfghngb", "895654"));
        TestParameter testParameter2= new TestParameter(parameter2);
        Parameter parameter3 = new Parameter("45340", "wergth", new ParameterCategory("12985", "werghnb", "29654"));
        TestParameter testParameter3 = new TestParameter(parameter3);

        List<TestParameter> testParameters = new ArrayList<>();
        testParameters.add(testParameter1);
        testParameters.add(testParameter3);
        testParameters.add(testParameter2);

        Diagnosis diagnosis = new Diagnosis(testParameters);

        String expRes = "### Diagnosis ### \n" + "Diagnosis: " + testParameters + "\n";

        assertEquals(expRes, diagnosis.toString());
    }
}
