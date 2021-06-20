package app.ui.console;

import app.controller.ManualReportController;


import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.*;
public class ManualReportUI implements Runnable {
    Scanner sc = new Scanner(in);

    private ManualReportController vcal;


    public ManualReportUI() throws IOException, ClassNotFoundException {
        this.vcal = new ManualReportController();

    }

    @Override
    public void run() {
        boolean flag = false;

        do{

            out.println("Report of covid cases");

            out.println("Write the intervals " );

            String interval = sc.next();
            out.println("Choose one algorithm(linear and multi)");
            String alg = sc.next();


            StringBuilder send = new StringBuilder();

            try {
                send.append(vcal.showReport(alg,interval));
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println();
            out.println(send);
            out.println();

            out.println("Send report?(1 yes 0 no)");
            int ola = sc.nextInt();
            if (ola == 1){

                vcal.send(send.toString());
                flag = true;
            }else{

                out.println("Not send");
                break;
            }
        }while (!flag);

    }
}
