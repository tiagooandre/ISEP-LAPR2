package app.ui.console;

import app.controller.RegisterTestResultController;
import app.mappers.dto.ParameterDTO;

import java.io.IOException;
import java.util.List;

import java.util.Scanner;

import static java.lang.System.*;

/**
 *
 * @author renan
 */
public class RegisterTestResultUI implements Runnable {

    Scanner sc = new Scanner(in);

    public RegisterTestResultUI() {
        // this is a empty constructor fot this class
    }

    public void run() {
        RegisterTestResultController rtc = null;
        try {
            rtc = new RegisterTestResultController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        boolean valid = false;

        do{
            out.println("\nPlease introduce the sample barcode number");
            String sampleCode = sc.next();
            if(rtc.getTest(sampleCode))
                valid = true;

        }while(!valid);

        //Gets the list of parameters and add their results
        List<ParameterDTO> parametersDTO = rtc.getParameters();
        for (int i=0; i<parametersDTO.size(); i++) {
            out.println("\n"+parametersDTO.get(i).toString());
            out.println("Result:");
            String result = sc.next();
            out.println("Metric:");
            String metric = sc.next();
            try {
                rtc.addResult(parametersDTO.get(i).getCode(), result, metric);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Shows results and asks for confirmation
        out.println("\n\n\nTEST RESULTS\n");
        out.println(rtc.showIntrucedData());
        out.println("\nSave this Test?\n 1) Yes\n-1)No");
        String addT = sc.next();
        if(addT.compareTo("1")==0){
            if(rtc.saveTestResult())
                out.println("Results registered");
        }
        else
            out.println("Results not registered");


    }

}