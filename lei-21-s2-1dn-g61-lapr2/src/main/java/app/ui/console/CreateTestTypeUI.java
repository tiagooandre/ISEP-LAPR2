/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.console;

import app.controller.CreateTestTypeController;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

/**
 *
 * @author renan
 */
public class CreateTestTypeUI implements Runnable {

    Scanner sc = new Scanner(in);

    public CreateTestTypeUI() {
        // it is a constructor empty
    }

    public void run() {

        CreateTestTypeController ttc = null;
        try {
            ttc = new CreateTestTypeController();
        }  catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        boolean valid = false;
        do {
            try {
                out.println("Please introduce the following data");
                out.println("Test type's code(must be composed of 5 alphanumeric chars)");
                String ttCode = sc.next();
                out.println("Test type's description(must have 1 to 15 chars)");
                String ttDescription = sc.next();
                out.println("Test type's collecting methods(must have 1 to 20 chars)");
                String ttMethods = sc.next();
                valid = true;

                if (ttc.createTestType(ttCode, ttDescription, ttMethods)) {
                    out.printf("Test type\n"
                            + "TestType Code: %s\n"
                            + "TestType Description: %s\n"
                            + "TestType Collecting methods: %s\n\n", ttCode, ttDescription, ttMethods);

                    int indT = 0;
                    out.println("Chose which categories will be given to the new test type:\n\n-1)Done\n");

                    for (int i=0; i<ttc.parameterCategoryList().size(); i++)
                        out.println(i + ")\n" + ttc.parameterCategoryList().get(i)+"\n\n");

                    while (indT != -1) {
                        indT = sc.nextInt();
                        if(indT != -1 && indT < ttc.parameterCategoryList().size())
                            ttc.fillParameterCategoryList(ttc.parameterCategoryList().get(indT));
                    }

                    out.println("Save the new Test Type?(1 to confirm 0 to delete)");

                    int choice = sc.nextInt();
                    if (choice == 1) {
                        if (ttc.saveTestType()) {
                            out.println("Success\n");
                        } else {
                            out.println("An error occurred while saving the test type\n");
                        }
                        for (int i=0; i<ttc.showAllTestTypes().size(); i++)
                            out.println(ttc.showAllTestTypes().get(i) + "\n" + ttc.showAllTestTypes().get(i).getCategories()+"\n");
                    }
                    else
                        out.println("\nTest Type not saved");
                }
                else
                    out.println("\nThis Test Type code already exist!");

            } catch (IllegalArgumentException e) {
                out.println("\nInvalid attributes for test type were given");
            }
        } while (!valid);
    }

}
