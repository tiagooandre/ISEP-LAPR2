package app.domain.model;

import auth.domain.model.Email;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CompanyTest {
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation()");

        Company company = new Company();
        company.setDesignation("Test for company.");

        String expRes = "Test for company.";

        assertEquals(expRes, company.getDesignation());
    }

    @Test
    public void testGetOrganizationRoleStore() {
        System.out.println("getOrganizationRoleStore()");

        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        OrganizationRole or2 = new OrganizationRole("RECEPTIONIST", "RECEPTIONIST", "Class");
        OrganizationRole or3 = new OrganizationRole("DOCTOR", "DOCTOR", "Class");

        List<OrganizationRole> list = new ArrayList<>();
        list.add(or);
        list.add(or2);
        list.add(or3);

        Company company = new Company();
        OrganizationRoleStore os = new OrganizationRoleStore();


        os.addOrganizationRole("ADMIN", "ADMIN", "Class");
        os.addOrganizationRole("RECEPTIONIST", "RECEPTIONIST", "Class");
        os.addOrganizationRole("DOCTOR", "DOCTOR", "Class");

        company.setOrganizationRoleStore(os);

        assertEquals(list, company.getOrganizationRoleStore().getRoles());
    }

    @Test
    public void testGetEmployeeStore() {
        System.out.println("getEmployeeStore()");

        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Tiago", "rua da fac", "12345678901", "map2000@iol.pt", "Hello");
        Employee emp1 = new Employee(or, "David", "rua da fac", "12345678801", "map2002@iol.pt", "Hello");
        Employee emp2 = new Employee(or, "Miguel", "rua da saude", "12345678900", "map2001@iol.pt", "Hello");

        List<Employee> list = new ArrayList<>();
        list.add(emp);
        list.add(emp1);
        list.add(emp2);

        Company company = new Company();
        EmployeeStore es = new EmployeeStore();
        es.saveEmployee(emp);
        es.saveEmployee(emp1);
        es.saveEmployee(emp2);

        company.setEmployeeStore(es);

        assertEquals(list, company.getEmployeeStore().getEmployeeList());
    }

    @Test
    public void testGetClinicalList() {
        System.out.println("getClinicalList()");

        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("12345", "Lab", "Rua 1", "12345678901", "1234567890");
        ClinicalAnalysisLaboratory cal1 = new ClinicalAnalysisLaboratory("12346", "Lab1", "Rua 2", "12345678902", "1234567891");
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("12347", "Lab2", "Rua 3", "12345678903", "1234567892");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        list.add(cal);
        list.add(cal1);
        list.add(cal2);

        Company company = new Company();

        company.setClinicalList(list);

        assertEquals(list, company.getClinicalList());
    }

    /*
    @Test
    public void testGetRegisterClinicalStore() {
        System.out.println("getRegisterClinicalStore()");

        ClinicalAnalysisLaboratory lab1 = new ClinicalAnalysisLaboratory("001DO","Lab1","Street1","11111111111", "1111111111");
        ClinicalAnalysisLaboratory lab2 = new ClinicalAnalysisLaboratory("001WA","Lab2","Street2","21111111112", "2111111112");
        ClinicalAnalysisLaboratory lab3 = new ClinicalAnalysisLaboratory("001MA","Lab3","Street3","31111111113", "3111111113");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        list.add(lab1);
        list.add(lab2);
        list.add(lab3);

        RegisterClinicalStore rs = new RegisterClinicalStore(list);
        rs.saveClinical(lab1);
        rs.saveClinical(lab2);
        rs.saveClinical(lab3);

        Company company = new Company();

        assertEquals(list, company.getRegisterClinicalStore().toString());
    }*/

    @Test
    public void testGetTestTypes() {
        System.out.println("getTestTypes()");

        TestType covidTest = new TestType("tt001", "CovidTest", "Swab");
        TestType bloodTest = new TestType("tt002", "BloodTest", "Blood");

        List<TestType> list = new ArrayList<>();
        list.add(covidTest);
        list.add(bloodTest);

        Company  company = new Company();
        company.setTestType(list);

        assertEquals(list, company.getTestTypes());
    }

    @Test
    public void testGetTestTypeStore() {
        System.out.println("getTestTypeStore()");

        TestType covidTest = new TestType("tt001", "CovidTest", "Swab");
        TestType bloodTest = new TestType("tt002", "BloodTest", "Blood");

        List<TestType> list = new ArrayList<>();
        list.add(covidTest);
        list.add(bloodTest);

        Company  company = new Company();
        company.setTestType(list);

        TestTypeStore ts = new TestTypeStore(list);

        assertEquals(list, company.getTestTypeStore().getTestTypes());
    }

    @Test
    public void testGetParameterCategoryList() {
        System.out.println("getParameterCategoryList()");

        ParameterCategory pc = new ParameterCategory("12345", "this is a description", "12345");
        ParameterCategory pc1 = new ParameterCategory("12346", "this is a description1", "12346");
        ParameterCategory pc2 = new ParameterCategory("12347", "this is a description2", "12347");

        List<ParameterCategory> list = new ArrayList<>();
        list.add(pc);
        list.add(pc1);
        list.add(pc2);

        Company company = new Company();
        company.setParameterCategoryList(list);

        assertEquals(list, company.getParameterCatergoryList());
    }

    @Test
    public void testGetParameterCategoryStore() {
        System.out.println("getParameterCategoryStore()");

        ParameterCategory pc = new ParameterCategory("12345", "this is a description", "12345");
        ParameterCategory pc1 = new ParameterCategory("12346", "this is a description1", "12346");
        ParameterCategory pc2 = new ParameterCategory("12347", "this is a description2", "12347");

        List<ParameterCategory> list = new ArrayList<>();
        list.add(pc);
        list.add(pc1);
        list.add(pc2);

        Company company = new Company();
        company.setParameterCategoryList(list);

        assertEquals(list, company.getParameterCategoryStore().getParameterCategories() );
    }

    @Test
    public void testGetParameterList() {
        System.out.println("getParameterList()");

        String code = "54321";
        ParameterCategory pc = new ParameterCategory("12345", "this is a description", "12345");
        Parameter p = new Parameter(code,"aaaaa", pc);
        Parameter p1 = new Parameter(code,"bbbbb", pc);

        List<Parameter> list = new ArrayList<>();
        list.add(p);
        list.add(p1);

        Company company = new Company();
        company.setParameterList(list);

        assertEquals(list, company.getParameterList());
    }

    @Test
    public void testGetParameterStore() {
        System.out.println("getParameterStore()");

        String code = "54321";
        ParameterCategory pc = new ParameterCategory("12345", "this is a description", "12345");
        Parameter p = new Parameter(code,"aaaaa", pc);
        Parameter p1 = new Parameter(code,"bbbbb", pc);

        List<Parameter> list = new ArrayList<>();
        list.add(p);
        list.add(p1);

        Company company = new Company();
        company.setParameterList(list);

        assertEquals(list, company.getParameterStore().getParameters());
    }


    @Test
    public void testGetClientList() {
        System.out.println("getClientList()");

        String PHONE_NUMBER = "1234567890";
        Client c = new Client("Joana","1234567890123456","18/05/2001", PHONE_NUMBER, PHONE_NUMBER,"contribute@geeksforgeeks.org","12345678901","Female");
        Client c1 = new Client("Tiago","1234567890123451","18/05/2000", PHONE_NUMBER, PHONE_NUMBER,"contribute1@geeksforgeeks.org","12345678900","Male");

        List<Client> list = new ArrayList<>();
        list.add(c);
        list.add(c1);

        Company company = new Company();
        company.setClientList(list);

        assertEquals(list, company.getClientList());
    }

    @Test
    public void testGetClientStore() {
        System.out.println("getClientStore()");

        String PHONE_NUMBER = "1234567890";
        Client c = new Client("Joana","1234567890123456","18/05/2001", PHONE_NUMBER, PHONE_NUMBER,"contribute@geeksforgeeks.org","12345678901","Female");
        Client c1 = new Client("Tiago","1234567890123451","18/05/2000", PHONE_NUMBER, PHONE_NUMBER,"contribute1@geeksforgeeks.org","12345678900","Male");

        List<Client> list = new ArrayList<>();
        list.add(c);
        list.add(c1);

        Company company = new Company();
        company.setClientList(list);

        assertEquals(list, company.getClientStore().getClients());
    }

    @Test
    public void testGetTestList() {
        System.out.println("getTestList()");

        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        app.domain.model.Test test2 = new app.domain.model.Test("098765432121");

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(test);
        list.add(test2);

        Company company = new Company();
        company.setTestList(list);

        assertEquals(list, company.getTestList());
    }

    @Test
    public void testGetTestStore() {
        System.out.println("getTestStore()");

        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        app.domain.model.Test test2 = new app.domain.model.Test("098765432121");

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(test);
        list.add(test2);

        Company company = new Company();
        company.setTestList(list);

        assertEquals(list, company.getTestStore().getTests());
        assertEquals(list, company.getTest1Store().getTests());
    }

    @Test
    public void testGetTestValideList() {
        System.out.println("getTestValideList()");

        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        app.domain.model.Test test2 = new app.domain.model.Test("098765432121");

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(test);
        list.add(test2);

        Company company = new Company();
        company.setTestValideList(list);

        assertEquals(list, company.getTestValideList());
    }

    @Test
    public void testGetValidationStore() {
        System.out.println("getValidationList()");

        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        app.domain.model.Test test2 = new app.domain.model.Test("098765432121");

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(test);
        list.add(test2);

        Company company = new Company();
        company.setTestValideList(list);

        TestValideStore ts = new TestValideStore(list);
        ts.addValide(test);
        ts.addValide(test2);

        assertEquals(list, company.getValidationStore().getTestsValids());
    }

    @Test
    public void testGetTestStore2() {
        System.out.println("getTestStore2()");

        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        app.domain.model.Test test2 = new app.domain.model.Test("098765432121");

        List<app.domain.model.Test> list = new ArrayList<>();
        list.add(test);
        list.add(test2);

        Company company = new Company();
        company.setTestList(list);

        assertEquals(list, company.getTestStore2().getTests());
    }

    @Test
    public void testGetReportList() {
        System.out.println("getReportList()");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola", pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola", d1);
        Report r2 = new Report("adeus", d1);

        List<Report> list_r = new ArrayList<>();
        list_r.add(r1);
        list_r.add(r2);

        Company company = new Company();
        company.setReportList(list_r);

        assertEquals(list_r, company.getReportList());
    }

    @Test
    public void testGetReportStore() {
        System.out.println("getReportStore()");

        app.domain.model.ParameterCategory pc = new ParameterCategory("09876","ola","12345");
        Parameter pa = new Parameter("01234","ola", pc);
        TestParameter t1 = new TestParameter(pa);
        List<TestParameter> list = new ArrayList<>();
        list.add(t1);
        Diagnosis d1 = new Diagnosis(list);
        Report r1 = new Report("ola", d1);
        Report r2 = new Report("adeus", d1);

        List<Report> list_r = new ArrayList<>();
        list_r.add(r1);
        list_r.add(r2);

        Company company = new Company();
        company.setReportList(list_r);

        assertEquals(list_r, company.getReportStore().getReports());
    }
}
