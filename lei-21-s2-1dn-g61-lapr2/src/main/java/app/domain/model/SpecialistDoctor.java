package app.domain.model;

public class SpecialistDoctor extends Employee{

    private int doctorIndexNumber;

    public SpecialistDoctor(OrganizationRole organizationRole, String name, String address, String phoneNumber, String email, String codeSOC, int doctorIndexNumber) {
        super(organizationRole, name, address, phoneNumber, email, codeSOC);
        this.doctorIndexNumber = doctorIndexNumber;
    }

}
