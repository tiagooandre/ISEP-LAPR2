package app.ui.console;

import app.controller.ValidatingWorkController;
import app.mappers.dto.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class ValidatingWorkUI implements Runnable {
    Scanner sc = new Scanner(in);

    private ValidatingWorkController vcal;

    public ValidatingWorkUI() throws IOException, ClassNotFoundException {
        this.vcal = new ValidatingWorkController();
    }

    @Override
    public void run() {
        boolean validate = false;

        try{
        do {
            List<TestDateDTO> testDTO = vcal.getTests();
               if ( testDTO.isEmpty()){
                   out.println("List is empty");
                   break;
               }

                int ind = 0;
                out.println("Chose which Tests will be Validated:(-1 is to leave)");
                for (TestDateDTO tes1DTO : vcal.getTests()) {
                    out.println(ind + ") " + tes1DTO);
                    ind++;
                }
                ind = sc.nextInt();
                if (ind != -1 && ind < vcal.getTests().size()){
                    vcal.validateTest(testDTO.get(ind).getCode());


                out.println("Save?(1 to confirm 0 to delete)");
                int choice = sc.nextInt();

                if (choice == 1) {
                    if (vcal.addTest()) {

                        try {
                            vcal.sendMail(vcal.getClient());
                        } catch (IOException e) {
                            e.printStackTrace();
                            vcal.eliminateTest();
                            break;
                        } catch (NullPointerException w) {
                            out.println("no clients were found to send email");
                            vcal.eliminateTest();
                            break;
                        }
                        out.println(vcal.show());
                        out.println("success");
                    }

                    out.println("Continue?(1 to confirm 0 to leave)");
                    int choice2 = sc.nextInt();
                    if (choice2 == 1) {

                        validate = false;
                    } else
                        validate = true;
                } else {
                    vcal.eliminateTest();
                    out.println("\nTest not saved");
                }
        }
                else{
                    validate=true;
                }

            }   while (!validate);

        } catch(NullPointerException e){
            out.println("no tests remaining");
        }
    }
}



