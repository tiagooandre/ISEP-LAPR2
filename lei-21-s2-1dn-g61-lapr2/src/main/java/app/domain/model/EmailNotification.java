/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Gon�alo
 */
public class EmailNotification {

    public EmailNotification(){
        //this is a constructor empty for this class
    }
    
     public static void sendEmailToClient(String message) throws IOException {
        File file = new File("emailAndSMSMessages.txt");
        FileWriter arq = new FileWriter(file);
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf(message);

        gravarArq.close();
        arq.close();
    }
    
}
