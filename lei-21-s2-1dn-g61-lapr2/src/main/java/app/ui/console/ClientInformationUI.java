package app.ui.console;

import app.controller.ClientInformationController;
import app.ui.MainJAVAFX;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.System.in;

public class ClientInformationUI implements Runnable {
    Scanner sc = new Scanner(in);

    private ClientInformationController vcrc;

    public ClientInformationUI() throws IOException, ClassNotFoundException {
        this.vcrc= new ClientInformationController();
    }

    public void run() {

        MainJAVAFX.main(null);

        vcrc.getClient();

        out.println("Your current personal data\n");
        out.println(vcrc.clientData());

        boolean valid=false;
        do{
            out.println("\n\nChoose the attribute to change(-1 to cancel)");
            int i = sc.nextInt();
            if(i>0 && i<9){
                out.println("Introduce new data:");
                String info = sc.next();
                try{
                    vcrc.changeData(i, info);
                    if(i==7)
                        out.println("For security reasons restart the login session");
                    out.println("Your personal data was updated");
                    valid = true;
                }catch(IllegalArgumentException e){
                    out.println("This attribute is invalid!");
                    valid = false;
                }
            }
            if(i==-1){
                out.println("Operation canceled");
                valid = true;
            }

        }while(!valid);
    }
}
