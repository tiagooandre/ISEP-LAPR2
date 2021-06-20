package app.ui.console;

import app.controller.RegisterClientController;

import app.domain.model.Client;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class RegisterClientUI implements Runnable {

    Scanner sc = new Scanner(in);

    private RegisterClientController rcal;
    public RegisterClientUI() throws IOException, ClassNotFoundException {
        this.rcal= new RegisterClientController();
    }

    public void run() {
        boolean valid = false;
        do {
            try {
                out.println("Please introduce the following data");
                out.println("Client name(must have 1 to 35 chars)");
                String name = sc.nextLine();
                out.println("Client cc(must have 16 digits)");
                String cc = sc.nextLine();
                out.println("Client Birth(must be in dd/MM/yyyy format)");
                String birth = sc.nextLine();
                out.println("Client NHSID(must have 10 digits)");
                String nhsid = sc.nextLine();
                out.println("Client TIN(must have 10 digits)");
                String tin = sc.nextLine();
                out.println("Client email");
                String email = sc.nextLine();
                out.println("Client PhoneNumber(must have 11 digits)");
                String phone = sc.nextLine();
                boolean confirm = Utils.confirm("Want to enter your gender? (yes/no)");
                valid=true;
                if (confirm) {
                    List<String> list = new ArrayList<>();
                    list.add("Male");
                    list.add("Female");
                    list.add("Other option");
                    String sex = (String) Utils.showAndSelectOne(list, "Select one?");
                    if (rcal.createCliente(name, cc, birth, nhsid, tin, email, phone, sex)) {
                        out.printf("Client\n"
                                + "Name: %s\n"
                                + "CC: %s\n"
                                + "Birth: %s\n"
                                + "nhsid: %s\n"
                                + "TIN: %s\n"
                                + "Email: %s\n"
                                + "Phone: %s\n"
                                + "Sex: %s\n\n\n\n", name, cc, birth, nhsid, tin, email, phone, sex);

                        doNext(email);

                    }

                } else {
                    if (rcal.createCliente(name, cc, birth, nhsid, tin, email, phone)) {
                        out.printf("Clinent\n"
                                + "Name: %s\n"
                                + "CC: %s\n"
                                + "Birth: %s\n"
                                + "nhsid: %s\n"
                                + "TIN: %s\n"
                                + "Email: %s\n"
                                + "Phone: %s\n\n\n\n", name, cc, birth, nhsid, tin, email, phone);

                        doNext(email);
                    }
                }
            } catch (IllegalArgumentException e) {
                out.println("\nInvalid attributes for Client were given");
            }
        } while (!valid);
    }

        public void doNext (String email){
            out.println("Save?(1 to confirm 0 to delete)");

            int choice = sc.nextInt();
            if (choice == 1) {
                if (rcal.saveClient()) {
                    out.println("Success");

                    try {
                        rcal.sendEmail(email);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                out.println("An error occurred");
            }


            out.println("\n\n");
            Map<String, Client> map = rcal.showAllUser();

            for (Map.Entry<String, Client> mapToListAllUser : map.entrySet()) {

                Client c = mapToListAllUser.getValue();

                out.println("Nome: " + c.getName());
                out.println("Email: " + c.getEmail());
                out.println("NHSID: " + c.getNhsid());
                out.println("TIN: " + c.getTin());
                out.println("CC: " + c.getCc());
                out.println("Birthday: " + c.getBirth());
                out.println("Sex: " + c.getSex());
                out.println("PhoneNumber: " + c.getPhonenumber());

                out.println("Password: " + mapToListAllUser.getKey());

            }
        }

    }





