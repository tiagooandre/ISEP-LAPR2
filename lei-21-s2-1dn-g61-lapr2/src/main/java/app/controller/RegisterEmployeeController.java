package app.controller;

import app.domain.model.*;
import app.mappers.RolesMapper;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;

import java.io.IOException;
import java.util.List;

import static java.lang.System.*;

public class RegisterEmployeeController {
    private Company company;
    private OrganizationRoleStore os;
    private EmployeeStore es;
    private Employee e;

    public RegisterEmployeeController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
        this.es = this.company.getEmployeeStore();
        this.os = this.company.getOrganizationRoleStore();
    }

    /**
     * @param company
     */
    public RegisterEmployeeController(Company company) {
        this.company = company;
        this.es = this.company.getEmployeeStore();
    }

    /**
     * @return List of OrganizationRolesDTO
     */
    public List<OrganizationRoleDTO> getRoles() {
        List<OrganizationRole> roles = this.os.getRoles();
        RolesMapper rm = new RolesMapper();
        return rm.toDTO(roles);
    }

    /**
     * @param empDTO A DTO containing the employee's attributes collected by the UI
     * @return True if the new employee was successfully created
     */
    public boolean createEmployee(EmployeeDTO empDTO)  {
        String roleId = empDTO.getOrganizationRole();
        OrganizationRole role = os.getRoleById(roleId);
        this.e = role.createEmployee(empDTO);
        return this.es.validateEmployeeAttributes(e);
    }

    /**
     *
     * @return true if employee doesn't already exists in the company and the employee was added successfully to the company's database
     */
    public boolean saveEmployee() {
        return this.es.saveEmployee(e);
    }

    public boolean createUser() {
        try {
            String pass = GeneratePassword.generatePassword();
            if (this.company.getAuthFacade().addUser(e.getNameEmployee(), e.getEmailEmployee().getEmail(), pass)) {
                String message =  "Hello. Your email is:"+ e.getEmailEmployee().getEmail() +"\n" +
                        "Your registration was successful and you can now start using the system.\n" +
                        "Your password to login is as follows: " + pass +"\n" +
                        "Thank you, best regards.";
                EmailNotification.sendEmailToClient(message);
                return true;
            }
            out.println("→ It wasn't possible to add the user.");
            return false;
        } catch (IOException ioException) {
            out.println("→ It wasn't possible to send the email.");
            return false;
        }
    }

    public boolean delete() {
        return es.remove(this.e);
    }

}
