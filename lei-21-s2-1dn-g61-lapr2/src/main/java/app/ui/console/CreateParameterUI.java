/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.console;


import app.controller.CreateParameterController;
import app.domain.model.ParameterCategory;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

/**
 *
 * @author Gon�alo
 */
public class CreateParameterUI implements Runnable{
    
    Scanner sc = new Scanner(in);
    
    
    public CreateParameterUI(){
        // it is a constructor empty
    }
    
    public void run() {

        CreateParameterController tcc = null;
        try {
            tcc = new CreateParameterController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        boolean valid = false;
        
        do{
            try{
                out.println("Please introduce the following data in order to create a new parameter");
                
                out.println("Please introduce the code that will identify this parameter");
                String code = sc.next();  //the user introduces the Parameter's code
                
                out.println("Parameter's description must be composed by 1 to 40 chars");
                String ttDescription = sc.next(); //the user introduces the Parameter's description
                
                out.println("Choose which category will be given to the parameter created ");
                ParameterCategory pc;

                assert tcc != null;
                for(ParameterCategory pc1 : tcc.getParameterCatergoryList()){  //presents the user all categories available
                   out.print(" Category:  " + pc1.getDescriptionPC() + "    Code   " + pc1.getCodePC() + " \n");
               }
               
               
                out.println("Enter the code correspondent to the category you want");
                String codeCategory = sc.next(); //the user introduces the Parameter's Category code
                pc = tcc.getCategoryByCode(codeCategory);
                
                
                valid = true;
                    
                if(tcc.createParameter(code,ttDescription, pc)){ // presents the info introduced by the user in order to be confirmed 
                    out.println("### Parameter ### \n" + "Code: " + code + "Description:   " + "\n" + ttDescription + "\n" + "Category:  " + pc + "\n");
                    
                 
                     
                      out.println("Save?(1 to confirm 0 to delete)"); // the user must confirm all data before adding the new parameter

                    int choice = sc.nextInt();
                    if (choice == 1) {
                        if (tcc.saveParameter()) {
                            out.println("Success");  // if user confirmed by pressing 1 the parameter is saved successfully
                        } else {
                            out.println("An error occurred"); // if user cancelled by pressing 0 the parameter is not saved
                        }
                    }
                }

                for (int i=0; i<tcc.parameterList().size(); i++)
                    out.println(tcc.parameterList().get(i) + "\n");
                

            } catch (IllegalArgumentException e) {
                out.println("Invalid parameters for parameter were given"); // in case the user introduces invalid input for the Parameter parameters
            }
                        
        }while (!valid);
               
    }
    
}
        
    

