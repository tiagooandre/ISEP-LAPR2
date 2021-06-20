package app.ui.console;

import app.controller.RegisterTestController;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestTypeDTO;

import java.io.IOException;
import java.util.List;

import java.util.Scanner;

import static java.lang.System.*;

/**
 *
 * @author renan
 */
public class RegisterTestUI implements Runnable {

    Scanner sc = new Scanner(in);

    private static final String NAME = "This issue is caused when:\n";
    private static final String ERROR = "Something went wrong!\n";

    public RegisterTestUI() {
        // this is a empty constructor fot this class
    }

    public void run() {
        RegisterTestController ctc = null;
        try {
            ctc = new RegisterTestController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        boolean valid = false;
        do {
            try {
                
                //Gets data to create a test
                boolean testCreated=false;     
                do{
                out.println("\nPlease introduce the following data");
                out.println("Test's NHS code(must be composed of 12 alphanumeric chars)");
                String testNHScode = sc.next();
                out.println("Client's TIN");
                String clientNHSid = sc.next();
                valid = true;
                
                
                //Gets the client and the code
                if(!ctc.createTest(testNHScode, clientNHSid))
                    out.println("\nSomething went wrong!\n"
                                     + NAME
                                     + "1)Client does not exist\n"
                                     + "2) Test code already registered\n");
                else
                    testCreated=true;
                }while(!testCreated);

                
                //Shows the list of test types
                List<TestTypeDTO> testTypesDTO = ctc.getTestTypes();   
                for (int i=0; i<testTypesDTO.size(); i++) {
                    out.println("\n"+testTypesDTO.get(i).toString());
                }
            
            
                //Sets the test type
                testCreated=false;
                do{
                    out.println("\nSelect a TestType by introducing its code:");
                    String ttCode = sc.next();
                    if(!ctc.setTestsType(ttCode))
                        out.println(ERROR
                                     + NAME
                                     + "1)TestType code is invalid\n\n");
                    else
                        testCreated=true;
                }while(!testCreated);
                      
            
                //Gets the list of categories of the test type
                List<ParameterCategoryDTO> categoriesDTO = ctc.getCategories();
                for (int i=0; i<categoriesDTO.size(); i++) {
                    out.println("\n"+categoriesDTO.get(i).toString());
                }
            
                //Sets the category
                testCreated=false;
                do{
                    out.println("\nSelect a Category by introducing its code:");
                    String pcCode = sc.next();
                    if(!ctc.setCategory(pcCode))
                        out.println(ERROR
                                     + NAME
                                     + "1)Category code is invalid\n\n");
                    else
                        testCreated=true;
                }while(!testCreated);
                
                
                //Gets the list of parameters from the chosen category
                List<ParameterDTO> parametersDTO = ctc.getParameters();
                for (int i=0; i<parametersDTO.size(); i++) {
                    out.println("\n"+parametersDTO.get(i).toString());
                }

                
                //Sets the parameters
                testCreated=false;
                do{
                    out.println("\nSelect a Parameter by introducing its code:");
                    String pCode = sc.next();
                    if(!ctc.addParameter(pCode))
                        out.println(ERROR
                                     + NAME
                                     + "1)Parameter code is invalid\n\n");
                    else{
                        out.println("Add another parameter?\n 1) Yes\n-1)No");
                        String addP = sc.next();
                        if(addP.compareTo("-1")==0)
                            testCreated=true;
                    }
                }while(!testCreated);
                 
                
                //Shows results and asks for confirmation
                out.println("\n\n\nTEST CREATED\n");
                out.println(ctc.showIntrucedData());
                out.println("\nSave this Test?\n 1) Yes\n-1)No");
                String addT = sc.next();
                if(addT.compareTo("1")==0){
                    if(ctc.saveTest())
                        out.println("Test registered");
                }
                else
                    out.println("Test not registered");
                      
            } catch (IllegalArgumentException e) {
                out.println("\nInvalid attributes for test were given");
            }
            
        } while (!valid);
    }

}