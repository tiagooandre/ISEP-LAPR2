package app.domain.model;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReportStoreTest {
    @Test
    public void ValidateRep(){
        System.out.println("validateReport");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola",d1);

        List<Report> rlist = new ArrayList<>();
        ReportStore store = new ReportStore(rlist);
        assertTrue(store.validateReport(r1));

    }
    @Test
    public void ValidateRep1(){
        System.out.println("validateReport");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = null;


        List<Report> rlist = new ArrayList<>();
        ReportStore store = new ReportStore(rlist);
        assertFalse(store.validateReport(r1));

    }
    @Test
    public void ValidateRep2(){
        System.out.println("validateReport");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola",d1);

        List<Report> rlist = new ArrayList<>();
        rlist.add(r1);
        ReportStore store = new ReportStore(rlist);
        assertFalse(store.validateReport(r1));

    }
    @Test
    public void SaveRep(){
        System.out.println("SaveReport");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola",d1);

        List<Report> rlist = new ArrayList<>();
        rlist.add(r1);
        ReportStore store = new ReportStore(rlist);
        assertFalse(store.saveReport(r1));

    }
    @Test
    public void SaveRep1(){
        System.out.println("SaveReport");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = null;

        List<Report> rlist = new ArrayList<>();

        ReportStore store = new ReportStore(rlist);
        assertFalse(store.saveReport(r1));

    }
    @Test
    public void SaveRep2(){
        System.out.println("SaveReport");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola",pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola",d1);

        List<Report> rlist = new ArrayList<>();

        ReportStore store = new ReportStore(rlist);
        assertTrue(store.saveReport(r1));

    }

}