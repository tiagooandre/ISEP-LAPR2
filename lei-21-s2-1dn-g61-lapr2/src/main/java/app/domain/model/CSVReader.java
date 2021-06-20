package app.domain.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * Creates an instance of the Test class using information from a CSV file
 * @author renan
 */
public class CSVReader {

    public String[] createTestFromFile(String fileName, int i){
        String[] lstNull = new String[0];
        try(FileInputStream fileIn = new FileInputStream(fileName)) {
            Scanner sc = new Scanner(fileIn);

            for(int k=0; k<i+1; k++)
                sc.nextLine();

            if(sc.hasNext()) {
                String testLine = sc.nextLine();
                return testLine.split(";");

            }
            } catch(IOException e) {
            out.println("File not found");
        }
        return null;
    }

}
