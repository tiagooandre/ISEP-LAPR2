package app.controller;

import app.domain.model.*;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Miguel Chen 1190897
 */

public class RegisterClinicalAnalysisLaboratoryController {
    /**
     * the company that registers clinical laboratory
     */
    private Company company;
    /**
     * the RegisterClinicalStore is used to create and save the laboratory
     */
    private RegisterClinicalStore store;
    /**
     * the clinical laboratory that is registered
     */
    private ClinicalAnalysisLaboratory cl;
    /**
     * Creates a controller getting the Company information from App
     */
    public RegisterClinicalAnalysisLaboratoryController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }
    /**Creates a controller from the Company, having it as a parameter
     * @param company
     */
    public RegisterClinicalAnalysisLaboratoryController(Company company) {
        this.company =company;
        this.cl = null;
    }
    /**
     * @param laboratoryID
     * @param name
     * @param address
     * @param phoneNumber
     * @param numberTIN
     * @return True if the new laboratory was added successfully to the company's database
     */
    public boolean createClinical(String laboratoryID, String name, String address, String phoneNumber, String numberTIN) {
        this.store = this.company.getRegisterClinicalStore();
        this.cl = this.store.createClinical(laboratoryID, name, address, phoneNumber, numberTIN);
        return this.store.validateClinical(cl);
    }
    /**
     * @return Validation if the laboratory does not exist in the company
     */
    public boolean saveClinical() {
        return this.store.saveClinical(cl);
    }

    /**
     *
     * @return All labs
     */
    public List<ClinicalAnalysisLaboratory> showAllClinical(){
        return this.company.getClinicalList();
    }

    /**
     *
     * @return list of test types
     */
    public List<TestType> testList(){
        return this.company.getTestTypes();
    }
    /**
     *
     * @param t the Test types
     */
    public void fillTestList(TestType t){
            this.cl.addTestType(t);
    }
}

