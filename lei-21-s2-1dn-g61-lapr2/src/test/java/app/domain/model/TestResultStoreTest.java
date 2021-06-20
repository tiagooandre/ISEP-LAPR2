package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestResultStoreTest {
    @Test
    public void validateResults(){
        System.out.println("testValidateResults");
        List<TestParameter> list = new ArrayList<>();
        ParameterCategory pc = new ParameterCategory("pc001","categoria","12345");
        Parameter p = new Parameter("pp001","parametro",pc);
        TestParameter tp = new TestParameter(p);
        tp.getTestResult();
        Date date = new Date();
        ReferenceValue v = new ReferenceValue("00000","ml",10,200,date);

        tp.addResult("100","ml",v);
        list.add(tp);
        TestResultStore trs = new TestResultStore(list);

        System.out.println(trs.validateResults(list));
        boolean exp = trs.validateResults(list);
        boolean atual = true;
        assertEquals(atual,exp);
    }
}