package app.domain.model;

import app.domain.shared.Constants;
import auth.AuthFacade;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import auth.domain.model.User;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private OrganizationRoleStore os;
    private EmployeeStore es;

    private static final String EXTEND_DOMAIN_MODEL_EMPLOYEE = "app.domain.model.Employee";
    private static final String PHONE_NUMBER = "1234567890";

    public Company(String designation) throws IOException, ClassNotFoundException {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.os = new OrganizationRoleStore();
        this.es = new EmployeeStore();

        //Default values

        this.clinicalList.add(lab1);
        this.clinicalList.add(lab2);
        this.clinicalList.add(lab3);
        this.clinicalList.add(lab4);
        this.clinicalList.add(lab5);
        this.clinicalList.add(lab6);
/*
        this.testTypeList.add(covidTest);
        this.testTypeList.add(bloodTest);

        this.testTypeList.get(0).addTestTypeCategory(covid);
        this.testTypeList.get(1).addTestTypeCategory(hemogram);
        this.testTypeList.get(1).addTestTypeCategory(cholesterol);

        this.parameterCategoryList.add(covid);
        this.parameterCategoryList.add(hemogram);
        this.parameterCategoryList.add(cholesterol);

        this.parameterCategoryList.get(0).addPCParameter(covidPositive);
        this.parameterCategoryList.get(1).addPCParameter(rbc);
        this.parameterCategoryList.get(1).addPCParameter(wbc);
        this.parameterCategoryList.get(1).addPCParameter(platelets);
        this.parameterCategoryList.get(1).addPCParameter(haemoglobin);
        this.parameterCategoryList.get(2).addPCParameter(hdl);

        this.parameterList.add(covidPositive);
        this.parameterList.add(rbc);
        this.parameterList.add(wbc);
        this.parameterList.add(platelets);
        this.parameterList.add(haemoglobin);*/

        //Organization Roles
        this.os.addOrganizationRole("ADMIN", Constants.ROLE_ADMIN, EXTEND_DOMAIN_MODEL_EMPLOYEE);
        this.os.addOrganizationRole("CCT",Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST, EXTEND_DOMAIN_MODEL_EMPLOYEE);
        this.os.addOrganizationRole("SD",Constants.ROLE_SPECIALISTDOCTOR, "app.domain.model.SpecialistDoctor");
        this.os.addOrganizationRole("LC",Constants.ROLE_LABORATORYCOORDINATOR, EXTEND_DOMAIN_MODEL_EMPLOYEE);
        this.os.addOrganizationRole("MLT",Constants.ROLE_MEDICALLABTECHNICIAN, EXTEND_DOMAIN_MODEL_EMPLOYEE);
        this.os.addOrganizationRole("R",Constants.ROLE_RECEPTIONIST, EXTEND_DOMAIN_MODEL_EMPLOYEE);

        try {
            this.getData();
        }catch(EOFException e){

        }

        AutoReportNHS timer = new AutoReportNHS(this.getValidationStore());
        timer.sendReport();

    }

    public Company() {
       
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    ////////////////////////////////////////////////////////////////////////////

    //OrganizationRoles
    /**
     *
     * @return The organization role store, responsible for managing the roles of the company
     */
    public OrganizationRoleStore getOrganizationRoleStore(){
        return os;
    }

    public void setOrganizationRoleStore(OrganizationRoleStore os) {
        this.os = os;
    }

    ////////////////////////////////////////////////////////////////////////////

    //User Story 7: Register new employee
    /**
     *
     * @return The Employee store, responsible for managing the employees of the company
     */
    public EmployeeStore getEmployeeStore(){
        return es;
    }

    public void setEmployeeStore(EmployeeStore es) {
        this.es = es;
    }

    ////////////////////////////////////////////////////////////////////////////

    //US8 : Register Clinical Laboratory

    /**
     * The company's list of clinics
     */
    private List<ClinicalAnalysisLaboratory> clinicalList = new ArrayList<>();

    /**
     * Gets the list of clinics
     *
     * @return The list of clinics
     */
    public List<ClinicalAnalysisLaboratory> getClinicalList(){
        return this.clinicalList;
    }

    public void setClinicalList(List<ClinicalAnalysisLaboratory> clinicalList) {
        this.clinicalList = clinicalList;
    }

    /**
     * Gets the clinic store
     *
     * @return The clinical store
     */
    public RegisterClinicalStore getRegisterClinicalStore() {
        return new RegisterClinicalStore(this.clinicalList);
    }

    ClinicalAnalysisLaboratory lab1 = new ClinicalAnalysisLaboratory("001DO","Lab1","Street1","11111111111", "1111111111");
    ClinicalAnalysisLaboratory lab2 = new ClinicalAnalysisLaboratory("001WA","Lab2","Street2","21111111112", "2111111112");
    ClinicalAnalysisLaboratory lab3 = new ClinicalAnalysisLaboratory("001MA","Lab3","Street3","31111111113", "3111111113");
    ClinicalAnalysisLaboratory lab4 = new ClinicalAnalysisLaboratory("001LR","Lab4","Street4","41111111114", "4111111114");
    ClinicalAnalysisLaboratory lab5 = new ClinicalAnalysisLaboratory("001SO","Lab5","Street5","51111111115", "5111111115");
    ClinicalAnalysisLaboratory lab6 = new ClinicalAnalysisLaboratory("001LN","Lab6","Street6","61111111116", "6111111116");
    ////////////////////////////////////////////////////////////////////////////
    
    //User Story 9: Create Test Type
    /**
     *  List of Test Types available
     */
    private List<TestType> testTypeList = new ArrayList<>();
    
    TestType covidTest = new TestType("tt001", "CovidTest", "Swab");
    TestType bloodTest = new TestType("tt002", "BloodTest", "Blood");
    /**
     * 
     * @return Company's list of test types
     */
    public List<TestType> getTestTypes(){
        return this.testTypeList;
    }

    public void setTestType(List<TestType> list) {
        this.testTypeList = list;
    }

    /**
     * 
     * @return The test type store, responsible for managing test type information
     */
    public TestTypeStore getTestTypeStore(){
        return new TestTypeStore(this.testTypeList);
    }

    ////////////////////////////////////////////////////////////////////////////
    
    //User Story 11: Create Parameter Category
    /**
     *  List of Parameter Categories available for the tests
     */
    private List<ParameterCategory> parameterCategoryList = new ArrayList<>();
    ParameterCategory covid = new ParameterCategory("pc001", "Covid", "nhs001");
    ParameterCategory hemogram = new ParameterCategory("pc002", "Hemogram", "nhs002");
    ParameterCategory cholesterol = new ParameterCategory("pc003", "Cholesterol", "nhs003");
    
    /**
     * 
     * @return Company's list of parameter categories
     */
    public List<ParameterCategory> getParameterCatergoryList(){
        return this.parameterCategoryList;
    }

    public void setParameterCategoryList(List<ParameterCategory> parameterCategoryList) {
        this.parameterCategoryList = parameterCategoryList;
    }
    
    /**
     * 
     * @return The test type store, responsible for managing test type information
     */
    public ParameterCategoryStore getParameterCategoryStore(){
        return new ParameterCategoryStore(this.parameterCategoryList);
    }

    ////////////////////////////////////////////////////////////////////////////
    

    
    //User Story 10: Create new Parameter
    /**
     *  List of Parameters available for the tests
     */
    private List<Parameter> parameterList = new ArrayList<>();
    Parameter covidPositive = new Parameter("IgGAN", "CovidPosive", covid);
    Parameter rbc = new Parameter("RBC00", "rbc", hemogram);
    Parameter wbc = new Parameter("WBC00", "wbc", hemogram);
    Parameter platelets = new Parameter("PLT00", "Platelets", hemogram);
    Parameter haemoglobin = new Parameter("HB000", "Haemoglobin", hemogram);
    Parameter hdl = new Parameter("HDL00", "HDL", cholesterol);
    
    /**
     * @return Company's list of parameters available for tests
     */
    public List<Parameter> getParameterList(){
        return this.parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    public List<ParameterCategory> getCategoryList(){
        return this.getCategoryList();
    }
    /**
     * 
     * @return The Parameter store, responsible for managing parameters for tests 
     */
    public ParameterStore getParameterStore(){
        return new ParameterStore(this.parameterList);
    }
    


    ////////////////////////////////////////////////////////////////////////////

    private List<User> user = new ArrayList<>();

    public List<User> getUser(){
        return this.user;
    }
    private List<Client> clientList = new ArrayList<>();

    public List<Client> getClientList(){
       return this.clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public RegisterClientStore getClientStore() {
         return new RegisterClientStore(this.clientList);
    }
     
    Client clientForTesting = new Client("Joana","1234567890123456","18/05/2001", PHONE_NUMBER, PHONE_NUMBER,"contribute@geeksforgeeks.org","12345678901","Female");
    
    ////////////////////////////////////////////////////////////////////////////
     
    //User Story 4: Register new Test
    
    
    /**
     * List of tests registered in the company 
     */
    private List<Test> testList = new ArrayList<>();

    /**
     * Get the list of tests registered in the company
     * @return The list of tests
     */
    public List<Test> getTestList(){
        return this.testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    /**
     * Creates a Test store
     * @return The Test store, responsible for managing tests for the company 
     */
    public TestStore getTestStore(){
        return new TestStore(this.testList);
    }

    public TestStore getTest1Store(){
        return new TestStore(this.testList);
    }


    ////////////////////////////////////////////////////////////////////
    /**
     * List of Validated tests registered in the company
     */
    private List<Test> testValideList = new ArrayList<>();
    /**
     * Get the list of validated tests registered in the company
     * @return The list of tests that are Validated
     */
    public List<Test> getTestValideList(){
        return this.testValideList;
    }

    public void setTestValideList(List<Test> testValideList) {
        this.testValideList = testValideList;
    }

    /**
     * Creates a Test store
     * @return The Test store, responsible for managing Validated tests for the company
     */
    public TestValideStore getValidationStore(){
        return new TestValideStore(this.testValideList);
    }
    
    ///////////////////////////////////////////////////////////////
    //User Story 14: Write a Report for a given Test
    
    private List<Report> reportList = new ArrayList<>();
    
    /**
     * Creates a Test store
     * @return The Test Store, responsible for managing tests for the company 
     */
    public TestStore getTestStore2(){
        return new TestStore(this.testList);
    }
    
    /**
     * @return The Report store, responsible for managing reports 
     */
    public ReportStore getReportStore(){
        return new ReportStore(this.reportList);
    }
    
    /**
     * @return Company's list of reports 
     */
    private final List<TestParameter> resultList = new ArrayList<>();

    /**
     * gets the list of reports
     *
     * @return Report list
     */
    public List<Report> getReportList(){
        return this.reportList;
    }

    public void setReportList(List<Report> report) {
        this.reportList = report;
    }

    /**
     * Gets the store for test results
     *
     * @return tet result store
     */
    public TestResultStore getTestResultStore(){
        return new TestResultStore(this.resultList);
    }

    /**
     * Serialize all data in teh system
     *
     * @throws IOException if the files are not found
     */
    public void serializeList() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("database//categories.bin");
        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(this.parameterCategoryList);
        fileOut.close();

        fileOut = new FileOutputStream("database//parameters.bin");
        outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(this.parameterList);
        fileOut.close();

        fileOut = new FileOutputStream("database//testTypes.bin");
        outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(this.testTypeList);
        fileOut.close();

        fileOut = new FileOutputStream("database//clients.bin");
        outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(this.clientList);
        fileOut.close();

        fileOut = new FileOutputStream("database//tests.bin");
        outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(this.testList);
        fileOut.close();

        fileOut = new FileOutputStream("database//validTests.bin");
        outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(this.testValideList);
        fileOut.close();

        fileOut = new FileOutputStream("database//clinics.bin");
        outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(this.clinicalList);
        fileOut.close();

        fileOut = new FileOutputStream("database//users.bin");
        outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(this.authFacade.getUsers());
        fileOut.close();

    }

    /**
     * Gets all the information from the binary files
     * @throws IOException if files were not found
     * @throws ClassNotFoundException if the object's class does not exist
     */
    public void getData() throws IOException, ClassNotFoundException {
        FileInputStream fileIn =new FileInputStream("database//categories.bin");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        this.parameterCategoryList = (List<ParameterCategory>) in.readObject();
        fileIn.close();

        fileIn =new FileInputStream("database//parameters.bin");
        in = new ObjectInputStream(fileIn);
        this.parameterList = (List<Parameter>) in.readObject();
        fileIn.close();

        fileIn =new FileInputStream("database//testTypes.bin");
        in = new ObjectInputStream(fileIn);
        this.testTypeList = (List<TestType>) in.readObject();
        fileIn.close();

        fileIn =new FileInputStream("database//clients.bin");
        in = new ObjectInputStream(fileIn);
        this.clientList = (List<Client>) in.readObject();
        fileIn.close();

        fileIn =new FileInputStream("database//tests.bin");
        in = new ObjectInputStream(fileIn);
        this.testList = (List<Test>) in.readObject();
        fileIn.close();

        fileIn =new FileInputStream("database//validTests.bin");
        in = new ObjectInputStream(fileIn);
        this.testValideList = (List<Test>) in.readObject();
        fileIn.close();

        fileIn =new FileInputStream("database//clinics.bin");
        in = new ObjectInputStream(fileIn);
        this.clinicalList = (List<ClinicalAnalysisLaboratory>) in.readObject();
        fileIn.close();

        fileIn =new FileInputStream("database//users.bin");
        in = new ObjectInputStream(fileIn);
        this.authFacade.setUsers((Set<User>) in.readObject());
        List<User> list = (List<User>) in.readObject();
        for(User u : list){
            this.authFacade.addUser(u.getName(),u.getPassword().passString(), u.getId().toString());
        }
        fileIn.close();

    }

}
