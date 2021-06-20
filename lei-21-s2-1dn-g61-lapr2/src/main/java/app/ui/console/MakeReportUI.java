package app.ui.console;

import app.controller.MakeReportController;;
import app.domain.model.Client;
import app.domain.model.Diagnosis;
import app.domain.model.Test;
import app.mappers.dto.TestReporDTO;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class MakeReportUI implements Runnable{
    Scanner sc = new Scanner(in);

    private MakeReportController vcal;

    public MakeReportUI() throws IOException, ClassNotFoundException {
        this.vcal = new MakeReportController();
    }

    @Override
    public void run() {
        boolean valid = false;
        Client cl;
        Test t;
        Diagnosis d=null;


        do {

            List<TestReporDTO> testDTO = vcal.getTests();

            int ind = 0;
            out.println("Chose the Test that is going to be Worked on :(-1 is to leave)");
            for (TestReporDTO tes1DTO : vcal.getTests()) {
                out.println(ind + ") " + tes1DTO);
                ind++;
            }
            ind = sc.nextInt();
            if (ind != -1 && ind < vcal.getTests().size()) {
                t = vcal.getTest(testDTO.get(ind).getCode());
                vcal.getResultsforthisTest();
                if(!vcal.validateResults()){
                    out.println("The results are invalid for the reference values");
                    valid = true;
                }
                else {
                    d = vcal.createDiagnosis();
                    out.println(vcal.createDiagnosis());
                    cl = vcal.getTestClient();

                    out.println("Write report");
                    out.println("\n");
                    sc.nextLine();
                    String text = sc.nextLine();

                    out.println("Save?(1 for save 0 for delete)");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        if (vcal.createReport(text,d)) {
                            vcal.saveReport();
                        }

                        Test ttt = vcal.getTest();
                        out.println(ttt.getReport().toString());

                        out.println("Continue?(1 to confirm 0 to leave)");
                        int choice1 = sc.nextInt();
                        if (choice1 == 1) {
                            // testDTO.remove(ind);
                            valid = false;
                        } else
                            valid = true;
                    } else
                        out.println("\nTest has no Report");
                }
            }
            else{
                valid=true;
            }

        } while (!valid);
    }
}





