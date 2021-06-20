package app.domain.model;

import auth.domain.model.Email;
import org.apache.commons.lang3.StringUtils;


public class Employee {

    /**
     *  employeeID: The id of the employee
     */
    private String employeeID;

    /**
     *  organizationRole: The role of the employee
     */
    private OrganizationRole organizationRole;

    /**
     *  nameEmployee: The name of the employee
     */
    private String nameEmployee;

    /**
     *  addressEmployee: The address of the employee
     */
    private String addressEmployee;

    /**
     *  phoneNumberEmployee: The phone number of the employee
     */
    private String phoneNumberEmployee;

    /**
     *  emailEmployee: The email of the employee
     */
    private Email emailEmployee;

    /**
     *  codeSOCEmployee: The codeSOC of the employee
     */
    private String codeSOCEmployee;

    private static int numberEmployees = 0;
    public static final String REGEX = "[0-9]+";

    public Employee(OrganizationRole organizationRole, String nameEmployee, String addressEmployee, String phoneNumberEmployee, String emailEmployee, String codeSOCEmployee) {
        this.organizationRole = organizationRole;
        setNameEmployee(nameEmployee);
        setAddressEmployee(addressEmployee);
        setPhoneNumberEmployee(phoneNumberEmployee);
        this.emailEmployee = new Email(emailEmployee);
        setCodeSOCEmployee(codeSOCEmployee);
        setEmployeeID(nameEmployee);
        numberEmployees++;

    }

    public void setNameEmployee(String nameEmployee) {
        if (StringUtils.isBlank(nameEmployee))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (nameEmployee.length()>35)
            throw new IllegalArgumentException("Name can't have more than 35 characters.");
        this.nameEmployee = nameEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        if (StringUtils.isBlank(addressEmployee))
            throw new IllegalArgumentException("Address cannot be blank.");
        this.addressEmployee = addressEmployee;
    }

    public void setPhoneNumberEmployee(String phoneNumberEmployee) {
        if (StringUtils.isBlank(phoneNumberEmployee))
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if (phoneNumberEmployee.length() != 11)
            throw new IllegalArgumentException("The phone number needs to have 11 digits.");
        if (!phoneNumberEmployee.matches(REGEX))
            throw new IllegalArgumentException("The phone number only accepts numbers.");
        this.phoneNumberEmployee = phoneNumberEmployee;
    }

    public void setCodeSOCEmployee(String codeSOCEmployee) {
        if (StringUtils.isBlank(codeSOCEmployee))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( (codeSOCEmployee.length() < 4) || (codeSOCEmployee.length() > 8))
            throw new IllegalArgumentException("Code must have 4 to 8 chars.");
        this.codeSOCEmployee = codeSOCEmployee;
    }

    public void setEmployeeID(String name) {
        String[] names = name.trim().split(" ");
        StringBuilder employee = new StringBuilder();
        //Inserting the letters
        for (String n : names) {
            employee.append(n.charAt(0));
        }
        //Inserting the zeros
        int length = String.valueOf(numberEmployees).length();
        for (int num = 0; num < 5-length; num++) {
            employee.append("0");
        }
        //Inserting the number in numberEmployees
        employee.append(String.valueOf(numberEmployees));
        this.employeeID = employee.toString().toUpperCase();
    }


    public String getPhoneNumberEmployee() {
        return phoneNumberEmployee;
    }

    public Email getEmailEmployee() {
        return emailEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public String getCodeSOCEmployee() {
        return codeSOCEmployee;
    }

    public String getEmployeeID() {
        return employeeID;
    }

}
