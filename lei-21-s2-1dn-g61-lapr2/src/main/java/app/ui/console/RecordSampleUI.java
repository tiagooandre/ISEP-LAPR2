package app.ui.console;

import app.controller.RecordSampleController;
import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestDTO;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class RecordSampleUI implements Runnable {
    Scanner sc = new Scanner(in);

    public RecordSampleUI() {
        // it is a constructor empty
    }

    public void run() {
        RecordSampleController rsc = null;
        try {
            rsc = new RecordSampleController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        int i;
        int option = 0;
        int numberSamples = 0;
        boolean valid = false;
        boolean verify = true;

        List<TestDTO> testsDTO = rsc.getTests();
        if (!testsDTO.isEmpty()) {
            out.println("RECORD A NEW SAMPLE:");
            out.println();
            try {
                do {
                    i = 1;
                    out.println("Tests:");
                    for (TestDTO testdto : testsDTO) {
                        out.printf("%d - ", i);
                        out.println(testdto.toString());
                        for (ParameterDTO parameterdto : testdto.getParameters()) {
                            out.print(testdto.toStringParameterDTO(parameterdto));
                        }
                        out.println("");
                        i++;
                    }
                    out.println("0 - Sair\n");
                    out.println("Choose an option:");
                    option = sc.nextInt();
                    if ((option >= 0) && (option <= testsDTO.size())) {
                        valid = true;
                    } else if (option != 0) {
                        out.println("This option is invalid, please choose another one.");
                    }
                    out.println();
                } while (!valid);

                if (option != 0) {
                    do {
                        out.println("Insert the number of samples associated to the chosen test:");
                        numberSamples = sc.nextInt();
                        if (numberSamples < 1) {
                            out.println("The number needs to be at least 1.");
                            out.println();
                        }
                    } while (numberSamples < 1);
                    rsc.getTest(testsDTO.get(option - 1));
                    for (i = 0; i < numberSamples; i++) {
                        verify = rsc.generateBarcode();
                        if (!verify) {
                            out.println("It wasn't possible to record the sample.");
                            break;
                        }
                        out.print("Barcode Number: ");
                        out.println(rsc.getSamples().get(i).getBarcode());
                    }
                    if (verify) {
                        rsc.setSampleData();
                        out.println("The samples were recorded successfully.");
                    }
                }

            } catch (InputMismatchException e) {
                out.println("It needs to be an number!");
                sc.next();
            }
        } else {
            out.println("There isn't any tests without samples associated.");
        }
    }
}