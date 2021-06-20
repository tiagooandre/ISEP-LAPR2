package app.mappers.dto;

public class EmployeeDTO {

    private String organizationRole;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String codeSOC;
    private int doctorIndexNumber;

    /**
     * @param organizationRole The role of the employee in the company
     * @param name The name of the employee
     * @param address The address of the employee
     * @param phoneNumber The phone number of the employee
     * @param email The email of the employee
     * @param codeSOC The codeSOC associated to the employee
     */
    public EmployeeDTO(String organizationRole, String name, String address, String phoneNumber, String email, String codeSOC, int doctorIndexNumber) {
        this.organizationRole = organizationRole;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.codeSOC = codeSOC;
        this.doctorIndexNumber = doctorIndexNumber;
    }

    public String getOrganizationRole() {
        return organizationRole;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCodeSOC() {
        return codeSOC;
    }

    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }
}
