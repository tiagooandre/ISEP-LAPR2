package app.ui.console;

import app.controller.RegisterClinicalAnalysisLaboratoryController;
import app.domain.model.TestType;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class RegiterClinicalAnalysisLaboratoryUI implements Runnable {
    Scanner sc = new Scanner(in);

    public RegiterClinicalAnalysisLaboratoryUI()
    {
        // it is a constructor empty
    }

    public void run()
    {
        RegisterClinicalAnalysisLaboratoryController rcal = null;
        try {
            rcal = new RegisterClinicalAnalysisLaboratoryController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        boolean valid = false;
        do {
            try {
        out.println("Please introduce the following data");
        out.println("Clinical Analysis Laboratory ID(must be composed of 5 alphanumeric chars)");
        String clID = sc.nextLine();
        out.println("Clinical Analysis Laboratory Name(must have 1 to 20 chars)");
        String clName = sc.nextLine();
        out.println("Clinical Analysis Laboratory Address(must have 1 to 30 chars)");
        String clAddress = sc.nextLine();
        out.println("Clinical Analysis Laboratory Phone(must have 11 digits)");
        String clPhone = sc.nextLine();
        out.println("Clinical Analysis Laboratory TIN(must have 10 digits)");
        String cltin = sc.nextLine();
        valid =true;



        if(rcal.createClinical(clID, clName, clAddress, clPhone, cltin)){
            out.printf("Clinical Analysis Laboratory\n"
                    + "LabID: %s\n"
                    + "Name: %s\n"
                    + "Address: %s\n"
                    + "PhoneNumber: %s\n"
                    + "TIN: %s\n\n\n\n", clID, clName, clAddress, clPhone, cltin);

            int ind=0;
            out.println("Chose which Test Type will be given to the new Laboratory:");

            for(TestType p : rcal.testList()){
                out.println(ind + ") " + p.getDescription());
                ind++;
            }


            while (ind != -1) {
                ind = sc.nextInt();
                if(ind != -1 && ind < rcal.testList().size())
                    rcal.fillTestList(rcal.testList().get(ind));
            }


            out.println("Save?(1 to confirm 0 to delete)");

            int choice = sc.nextInt();
            if(choice==1) {
                if (rcal.saveClinical())
                    out.println("Success");
                else
                    out.println("An error occurred");
                out.println("\n\n");
                for (int i = 0; i < rcal.showAllClinical().size(); i++)

                    out.println(rcal.showAllClinical().get(i) + "\n" + rcal.showAllClinical().get(i).getTypeTests() + "\n");
            } else
                out.println("\nlab not saved");
            }
            else
                out.println("\nThis Lab has the same atributes as other existing one!");

    } catch (IllegalArgumentException e) {
                out.println("\nInvalid attributes for Clinical Laboratories Analysis were given");
            }
        } while (!valid);
    }
}
