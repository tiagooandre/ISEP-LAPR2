package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client implements Serializable {
    /**
     * name of the client
     */
    private String name;
    /**
     * email of the client
     */
    private Email emailm;
    /**
     * nhs id of the client
     */
    private String nhsid;
    /**
     * tin number of the client
     */
    private String tin;
    /**
     * citizen card of the client
     */
    private String cc;
    /**
     * birth date of the client
     */
    private String birth;
    /**
     * sex of the client
     */
    private String sex;
    /**
     * phone number of the client
     */
    private String phonenumber;

    /**
     * lists of tests of client
     */
    private List<Test> lstTest =  new ArrayList<>();

    // condition used to do the check
    private static final String REGULAR_EXPRESSION = "[0-9]+";

    /**
     * creates client with the atributes below
     * @param name
     * @param cc
     * @param birth
     * @param nhsid
     * @param tin
     * @param email
     * @param phonenumber
     * @param sex
     */
    public Client (String name, String cc, String birth, String nhsid, String tin, String email, String phonenumber, String sex){
        checkParameters( name, cc, birth, nhsid, tin, phonenumber);
        this.name = name;
        this.cc = cc;
        this.birth = birth;
        this.nhsid = nhsid;
        this.tin = tin;
        this.emailm = new Email(email);
        this.phonenumber = phonenumber;
        this.sex = sex;
    }

    /**
     * creates client with the atributes below
     * @param name
     * @param cc
     * @param birth
     * @param nhsid
     * @param tin
     * @param email
     * @param phonenumber
     */
    public Client (String name, String cc, String birth, String nhsid, String tin, String email, String phonenumber){
        checkParameters( name, cc, birth, nhsid, tin, phonenumber);
        this.name = name;
        this.cc = cc;
        this.birth = birth;
        this.nhsid = nhsid;
        this.tin = tin;
        this.emailm = new Email(email);
        this.phonenumber = phonenumber;
        this.sex = "anonymous";
    }

    public Client() {


    }

    /**
     * checks all the criteria
     * @param name
     * @param cc
     * @param birth
     * @param nhsid
     * @param tin
     * @param phonenumber
     */
    public void checkParameters(String name, String cc, String birth, String nhsid, String tin, String phonenumber){
        checkNameRules(name);
        checkCCRules(cc);
        checkDateRules(birth);
        checkNhsIDRules(nhsid);
        checkNumberTINRules(tin);
        checkPhoneNumberRules(phonenumber);
    }
    /**
     * @param phoneNumber check if phoneNumber has 11 digits
     */
    private void checkPhoneNumberRules(String phoneNumber) {
        if (phoneNumber.length() != 11 || !phoneNumber.matches(REGULAR_EXPRESSION))
            throw new IllegalArgumentException("Phone Number must be 11 numbers.");
    }
    /**
     * @param numberTIN check if numberTIN has 10 digits
     */
    private void checkNumberTINRules(String numberTIN) {
        if (numberTIN.length() != 10 || !numberTIN.matches(REGULAR_EXPRESSION))
            throw new IllegalArgumentException("TIN number must be 10 numbers.");
    }
    /**
     * @param nhsid check if nhsID has 10 numbers
     */
    private void checkNhsIDRules(String nhsid) {
        if (nhsid.length() != 10 || !nhsid.matches(REGULAR_EXPRESSION))
            throw new IllegalArgumentException("NHSID must be 10 digits.");
    }
    /**
     * @param name check if name has no more than 35 chars and more than 1
     */
    private void checkNameRules(String name) {
        if (name.length() < 1 || name.length() > 35)
            throw new IllegalArgumentException("Name must be no more than 35 car.");
    }
    /**
     * check if cc has 16 numbers
     *
     * @param cc citizen card
     */
    private void checkCCRules(String cc) {
        if (cc.length() != 16 || !cc.matches(REGULAR_EXPRESSION))
            throw new IllegalArgumentException("CC must be 16 digits.");
    }
    /**
     * @param birth check if data has the format
     */
    private void checkDateRules(String birth) {
        int c =3;
        String[] date = birth.split("/");
        if (date.length != c || Integer.parseInt(date[0]) > 31 || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) < 1870)
            throw new IllegalArgumentException("Format is wrong");
        }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return emailm.getEmail();
    }

    /**
     *
     * @return nhsid
     */
    public String getNhsid() {
        return nhsid;
    }

    /**
     *
     * @return TIN
     */
    public String getTin() {
        return tin;
    }

    /**
     *
     * @return CC
     */
    public String getCc() {
        return cc;
    }

    /**
     *
     * @return birth date
     */
    public String getBirth() {
        return birth;
    }

    /**
     *
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @return Phone number
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     *Changes the Client name if it is valid
     * @param name
     */
    public void setName(String name) {
        checkNameRules(name);
        this.name = name;
    }

    /**
     *
     * @param email
     */
    public void setEmail(Email email) {
        this.emailm = email;
    }

    /**
     *Changes the Client nhsid if it is valid
     * @param nhsid
     */
    public void setNhsid(String nhsid) {
        checkNhsIDRules(nhsid);
        this.nhsid = nhsid;
    }

    /**
     *Changes the Client TIN if it is valid
     * @param tin
     */
    public void setTin(String tin) {
        checkNumberTINRules(tin);
        this.tin = tin;
    }

    /**
     *Changes the Client cc if it is valid
     * @param cc
     */
    public void setCc(String cc) {
        checkCCRules(cc);
        this.cc = cc;
    }

    /**
     *Changes the Client birth date if it is valid
     * @param birth
     */
    public void setBirth(String birth) {
        checkDateRules(birth);
        this.birth = birth;
    }

    /**
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *Changes the Client phone number if it is valid
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        checkPhoneNumberRules(phonenumber);
        this.phonenumber = phonenumber;
    }


    /**
     * add test to a list
     * @param test tests complete done by client
     */
    public void addTest(Test test){
        this.lstTest.add(test);
    }

    /**
     * returns a tests done for client
     * @return lists of test make by client
     */
    public List<Test> getLstTestComplete() {
        return lstTest;
    }

    /**
     *
     * @return Client atributes
     */
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email=" + emailm +
                ", nhsid='" + nhsid + '\'' +
                ", tin='" + tin + '\'' +
                ", cc='" + cc + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

    /**
     * Gets the current user data
     *
     * @return String with all the attributes from the client
     */
    public String clientData(String p){
        return String.format("1) Name: %s\n" +
                        "2) Birth date: %s\n" +
                        "3) NHS id: %s\n" +
                        "4) Phone number: %s\n" +
                        "5) E-mail: %s\n" +
                        "6) Gender: %s\n" +
                        "7) Password: %s"
                , this.getName(), this.getBirth(), this.getNhsid(), this.getPhonenumber(), this.getEmail(), this.getSex(), p);
    }

/*
    public void sorting(List<Client> listC) throws IOException {
        SortingAl sa = App.sort1();
        Collections.sort(listC,sa);
    }*/

}
