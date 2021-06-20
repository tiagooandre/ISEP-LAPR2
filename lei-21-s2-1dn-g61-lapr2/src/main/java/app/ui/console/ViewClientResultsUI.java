package app.ui.console;

import app.controller.ViewClientResultsController;
import app.domain.model.*;
import app.mappers.dto.TestDTO;
import app.ui.MainJAVAFX;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.*;

public class ViewClientResultsUI implements Runnable {
    Scanner sc = new Scanner(in);

    private ViewClientResultsController vcrc;

    public ViewClientResultsUI() throws IOException, ClassNotFoundException {
        this.vcrc = new ViewClientResultsController();
    }

    @Override
    public void run() {
        //MainJAVAFX.main(null);
        List<TestDTO> lstTestsDTO = vcrc.getTestsDTOCompleteForThisClient();
        List<Test> lstTest = vcrc.getTestsOrdered(lstTestsDTO);

        if (lstTest.isEmpty()) {
            out.println("You don´t have any tests done");
        }else{
            out.println("Now we are going to show you your tests done.");

            int count = 0;
            for (Test test : lstTest) {
                count++;
                String code = test.getCode();
                String nhscode = test.getNHScode();
                Date dateRegistration = test.getDateRegistration();
                Time timeRegistration = test.getTimeRegistration();

                out.println("Test " + count + " -> Code: " + code + ", NHSCode: " + nhscode + ", Date of registration: " + dateRegistration + ", Time of registration: " + timeRegistration);
            }

            boolean flag = false;
            Test t;
            int verification = 3;
            do {
                out.println("\nNow introduce the test´s nhs code you want to see the results");
                String nhsCode = sc.nextLine();
                t = vcrc.getTestByNhsCode(nhsCode);
                if (t == null) {
                    if (verification == 0) {
                        out.println("you exceeded the attempts");
                        break;
                    }
                    out.println("ERROR: " + nhsCode + " -> this nhs code is invalid.");
                    out.println("You have more " + verification + " attempts.");

                    verification--;
                } else {
                    flag = true;
                    List<TestParameter> testParameters = vcrc.getResultsForThisTest(t);

                    out.println("This is your results for this test");
                    out.println(testParameters);
                    try {
                        out.println("This is your report for this test");
                        out.println(vcrc.getReport(t).getText());
                    }catch(NullPointerException e){
                        out.println("There is no report for this test");
                    }
                }

            } while (!flag);
        }

    }
}