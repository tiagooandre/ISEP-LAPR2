/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.console;


import app.controller.CreateParameterCategoryController;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

/**
 *
 * @author Renan
 */
public class CreateParameterCategoryUI implements Runnable{
    Scanner sc = new Scanner(in);

    public CreateParameterCategoryUI() {
        // it is a constructor empty
    }

    public void run() {

        CreateParameterCategoryController ttc = null;
        try {
            ttc = new CreateParameterCategoryController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        boolean valid = false;
        do {
            try {
                out.println("Please introduce the following data");
                out.println("Parameter category's code(must be composed of 4 to 8 alphanumeric chars)");
                String pcCode = sc.next();
                out.println("Parameter category's description(must have 1 to 40 chars)");
                String pcDescription = sc.next();
                out.println("Parameter category's NHS id(must have 4 to 8 chars)");
                String pcNHS = sc.next();
                valid = true;

                if (ttc.createParameterCategory(pcCode, pcDescription, pcNHS)) {
                    out.printf("Test type\n"
                            + "ParameterCategory Code: %s\n"
                            + "ParameterCategory Description: %s\n"
                            + "ParameterCategory NHS id: %s\n\n", pcCode, pcDescription, pcNHS);

                    int indP = 0;
                    out.println("Chose which parameters will be given to the new parameter category:\n-1)Done\n");

                    for (int j=0; j<ttc.parameterList().size(); j++)
                        out.println(j + ")\n" + ttc.parameterList().get(j)+"\n\n");

                    while (indP != -1) {
                        indP = sc.nextInt();
                        if(indP != -1 && indP < ttc.parameterList().size())
                            ttc.fillParameterList(ttc.parameterList().get(indP));
                    }

                    out.println("Save the new Parmeter Category?(1 to confirm 0 to delete)");

                    int choice = sc.nextInt();
                    if (choice == 1) {
                        if (ttc.saveParameterCategory()) {
                            out.println("Success\n");
                        } else {
                            out.println("An error occurred while saving the test type\n");
                        }
                        for (int i=0; i<ttc.showAllParameterCategories().size(); i++)
                            out.println(ttc.showAllParameterCategories().get(i) + "\n" + ttc.showAllParameterCategories().get(i).getParameters()+"\n");
                    }
                    else
                        out.println("\nParameter Category not saved");
                }
                else
                    out.println("\nThis Parameter Category code already exist!");

            } catch (IllegalArgumentException e) {
                out.println("\nInvalid attributes for Parameter Category were given");
            }
        } while (!valid);
    }

}
