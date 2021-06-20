package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.mappers.dto.EmployeeDTO;
import app.mappers.dto.OrganizationRoleDTO;

import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class RegisterEmployeeUI implements Runnable {
    Scanner sc = new Scanner(in);

    public RegisterEmployeeUI() {
        // it is a constructor empty
    }

    public void run() {
        RegisterEmployeeController rec = null;
        try {
            rec = new RegisterEmployeeController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        int i;
        boolean valid = false;
        String idRole = "";
            out.println("REGISTER A NEW EMPLOYEE:");
            out.println();

            List<OrganizationRoleDTO> orDTO = rec.getRoles();

            do {
            i = 0;
            out.println("Roles:");
            for (OrganizationRoleDTO r : orDTO) {
                out.println(r.toString());
            }
            out.println();
            out.println("Write the employee role description:");
            idRole = sc.nextLine();

            do {
                if ((orDTO.get(i).getId().equalsIgnoreCase(idRole)) || orDTO.get(i).getDescription().equalsIgnoreCase(idRole)) {
                    idRole = orDTO.get(i).getId();
                    valid = true;
                }
                i++;
            } while ((!valid) && (i < orDTO.size()));
            if (!valid) {
                out.println(idRole + "role doesn't exist");
            }
        } while (!valid);

            try {
                out.print("Insert employee's name:");
                String name = sc.nextLine();
                out.print("Insert employee's address:");
                String address = sc.nextLine();
                out.print("Insert employee's phone number (must have 11 digits): ");
                String phoneNumber = sc.nextLine();
                out.print("Insert employee's email:");
                String email = sc.nextLine();
                out.print("Insert employee's Standard Occupational Code (must be between 4 and 8 characters):");
                String codeSOC = sc.nextLine();

                out.println();

                int doctorIndexNumber = 0;
                if (idRole.equalsIgnoreCase("SD")) {
                    out.print("Insert employee's doctor index number:");
                    doctorIndexNumber = sc.nextInt();
                    out.println();
                }
                out.println();

                EmployeeDTO empDTO = new EmployeeDTO(idRole, name, address, phoneNumber, email, codeSOC, doctorIndexNumber);

                boolean end = false;

                //Show the data
                if (rec.createEmployee(empDTO)) {
                    out.printf("Employee:\n"
                            + "Organization Role: %s\n"
                            + "Name: %s\n"
                            + "Address: %s\n"
                            + "Phone Number: %s\n"
                            + "Email: %s\n"
                            + "Standard Occupational Code: %s\n\n\n\n", idRole, name, address, phoneNumber, email, codeSOC);
                    if (idRole.equalsIgnoreCase("CD"))
                        out.println("Doctor Index Number:" + doctorIndexNumber);
                } else {
                    out.println("→ This employee is already registered in the system.");
                    end = true;
                }

                //Confirm
                while (!end) {
                    out.println("Save?(1 to confirm 0 to delete)");

                    int option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        if ((rec.saveEmployee()) && (rec.createUser())) {
                            out.println("Success");
                        } else {
                            out.println("→ An error occurred");
                        }
                        end = true;
                    } else if (option == 0) {
                        if (rec.delete()) {
                            out.println("Is wasn't possible to delete de employee.");
                        } else {
                            out.println("Deleted successfully.");
                        }
                        end = true;
                    } else {
                        out.println("→ Option not valid!");
                    }
                }


        } catch (IllegalArgumentException e) {
                out.println("→ " + e.getMessage());
        } catch (InputMismatchException e) {
                out.println("→ The doctor occupational number needs to be a number!");
                sc.nextLine();
        }
    }
}
