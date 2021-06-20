package app.ui.console;

import app.controller.TestFileController;
import app.ui.Main;
import app.ui.MainJAVAFX;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class TestFileUI implements Runnable {

    public void run() {

        //MainJAVAFX.main(null);



        final String TEST = "**+TEST ";
        final String ERROR = " not added: IllegalArgumentException***";
        Scanner sc = new Scanner(in);
        boolean fileValid = true;
        int ts = 0;
        int tsN = 0;
        TestFileController tfc = null;
        try {
            tfc = new TestFileController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        //Gets the file with the test
        out.println("File name:");
        String file = sc.next();

        do {

            boolean test = true;
            try {
                if(!tfc.getTestLine(file, ts))
                    fileValid = false;

            } catch (IllegalArgumentException e) {
                out.println("File not found");
            }

            if(fileValid) {
                ts++;

                //Checks the NHS Code
                try {
                    tfc.validCode();
                }catch(IllegalArgumentException e){
                    test=false;
                    tsN++;
                    out.println(TEST+(ts)+ERROR);
                }

                //Checks the lab
                if(test){
                    try{
                        tfc.validLab();;
                    }catch (IllegalArgumentException e){
                        test = false;
                        tsN++;
                        out.println(TEST+(ts)+ERROR);
                    }
                }

                //Check the client
                try {
                    tfc.validClient();
                } catch (IllegalArgumentException | IOException e) {
                    test=false;
                    tsN++;
                    out.println(TEST+(ts)+ERROR);
                }

                //Checks the TestType
                try {
                    tfc.validTestType();
                }catch(IllegalArgumentException e){
                    test=false;
                    tsN++;
                    out.println(TEST+(ts)+ERROR);
                }

                //Checks the Category
                try {
                    tfc.validCategory();
                }catch(IllegalArgumentException e){
                    test=false;
                    tsN++;
                    out.println(TEST+(ts)+ERROR);
                }

                //Checks the Parameters
                try {
                    tfc.validParameter();
                }catch(IllegalArgumentException | IOException  e){
                    test=false;
                    tsN++;
                    out.println(TEST+(ts)+ERROR);
                }

                try {
                    tfc.validDateTime();
                }catch(IllegalArgumentException e){
                    test=false;
                    tsN++;
                    out.println(TEST+(ts)+ERROR);
                }

                if(test){
                    tfc.addCreatedTest();
                    out.println(TEST+(ts)+"***");
                }

            }
        }while(fileValid);
        out.println(ts - tsN +" tests were added");
        Main.main(null);
        }


}
