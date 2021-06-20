package app.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Chen 1190897
 */

public class ClinicalAnalysisLaboratory implements Serializable {
    /**
     * laboratoty id
     */
    private String laboratoryID;
    /**
     * laboratory name
     */
    private String name;
    /**
     * laboratory adress
     */
    private String adress;
    /**
     * laboratory phone number
     */
    private String phoneNumber;
    /**
     * laboratory tin number ID
     */
    private String numberTIN;
    /**
     * list of the test types
     */
    private List<TestType> testTypelist = new ArrayList<>();

    /**
     * list of the test
     */
    private List<Test> testlist = new ArrayList<>();

    /**creates the lab with all the atributes below
     * @param laboratoryID
     * @param name
     * @param address
     * @param phoneNumber
     * @param numberTIN
     */
    public ClinicalAnalysisLaboratory(String laboratoryID, String name, String address, String phoneNumber, String numberTIN) {
        allcheck(laboratoryID,name,address,phoneNumber,numberTIN);
        this.laboratoryID = laboratoryID;
        this.name = name;
        this.adress = address;
        this.phoneNumber = phoneNumber;
        this.numberTIN = numberTIN;

    }

    /**
     * checks all the criteria
     * @param laboratoryID
     * @param name
     * @param adress
     * @param phonenumber
     * @param numberTIN
     */
    public void allcheck(String laboratoryID, String name, String adress, String phonenumber, String numberTIN){
        checkLabIDRules(laboratoryID);
        checkNameRules(name);
        checkAddressRules(adress);
        checkNumberTINRules(numberTIN);
        checkPhoneNumberRules(phonenumber);
    }
    /**
     * @param phoneNumber check if phoneNumber has 11 digits
     */
    private void checkPhoneNumberRules(String phoneNumber) {
        if (phoneNumber.length() != 11 || !phoneNumber.matches("[0-9]+"))
            throw new IllegalArgumentException("Phone Number must be 11 numbers.");
    }
    /**
     * @param numberTIN check if numberTIN has 10 digits
     */
    private void checkNumberTINRules(String numberTIN) {
        if (numberTIN.length() != 10 || !numberTIN.matches("[0-9]+"))
            throw new IllegalArgumentException("TIN number must be 10 numbers.");
    }
    /**
     * @param laboratoryID check if laboratoryID has 5 aplhanumbers
     */
    private void checkLabIDRules(String laboratoryID) {
        if (laboratoryID.length() != 5 || !laboratoryID.matches("[a-zA-Z0-9]+"))
            throw new IllegalArgumentException("LabID must be 5 aphamunbers.");
    }
    /**
     * @param address check if address has no more than 30 chars and more than 1
     */
    private void checkAddressRules(String address) {
        if (address.length() <1 || address.length() >30)
            throw new IllegalArgumentException("Address must be no more than 30 car.");
    }
    /**
     * @param name check if name has no more than 20 chars and more than 1
     */
    private void checkNameRules(String name) {
        if (name.length() < 1 || name.length() > 20)
            throw new IllegalArgumentException("Name must be no more than 20 car.");
    }
    /**
     * @return laboratoryID
     */
    public String getLaboratoryID() {
        return this.laboratoryID;
    }
    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * @return address
     */
    public String getAdress() {
        return adress;
    }
    /**
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @return numberTIN
     */
    public String getNumberTIN() {
        return numberTIN;
    }
    /**
     * Changes the Lab id if it is valid
     * @param laboratoryID
     */
    public void setLaboratoryID(String laboratoryID) {
        checkAddressRules(laboratoryID);
        this.laboratoryID = laboratoryID;
    }
    /**
     * Changes the Lab name if it is valid
     * @param name
     */
    public void setName(String name) {
        checkNameRules(name);
        this.name = name;
    }
    /**
     * Changes the Lab address if it is valid
     * @param adress
     */
    public void setAdress(String adress) {
        checkAddressRules(adress);
        this.adress = adress;
    }
    /**
     * Changes the Lab phoneNumber if it is valid
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        checkPhoneNumberRules(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
    /**
     * Changes the Lab TIN if it is valid
     * @param numberTIN
     */
    public void setNumberTIN(String numberTIN) {
        checkNumberTINRules(numberTIN);
        this.numberTIN = numberTIN;
    }
    /**
     * @return Test types performed in this lab
     */
    public List<TestType> getTypeTests(){
        return this.testTypelist;
    }
    /**
     *
     * @param t The new test type for this lab
     */
    public void addTestType(TestType t){
        this.testTypelist.add(t);
    }
    /**
     * @return data of ClinicalAnalysisLaboratory
     */
    @Override
    public String toString() {
        return "ClinicalAnalysisLaboratory{" +
                "laboratoryID='" + laboratoryID + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", numberTIN=" + numberTIN +
                '}';
    }

    /**
     * Adds a test to this lab
     *
     * @param t The test being added
     */
    public void addTest(Test t){
        this.testlist.add(t);
    }

    public List<Test> getTests(){
        return this.testlist;
    }
}

