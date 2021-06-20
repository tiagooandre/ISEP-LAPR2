package app.ui.console;

import app.controller.CheckResultController;
import app.domain.model.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.*;

public class CheckResultUI implements Runnable {
    Scanner sc = new Scanner(in);


    private CheckResultController crc = new CheckResultController();

    public CheckResultUI() throws IOException, ClassNotFoundException {
        // this is a constructor empty for yhis class
    }


    public void run() {


        boolean flag = false;

        do {

            out.println("Client list");

            out.println("Choose the Client to view the results(-1 to leave)");


            List<Client> list = new ArrayList<>();

            try {

                list = crc.sortList();
                crc.showSort(list);

            } catch (IOException e) {

                e.printStackTrace();

            }

            int ind = sc.nextInt();

            if (ind != -1 && ind < list.size()) {

                out.println("Test of the Client");

                out.println();

                out.println();

                crc.showTest(this.crc.getTestFromCL(list.get(ind)));

            }
            out.println("Continue to view the Clients(1 yes 0 no)");

            int ch = sc.nextInt();

            if (ch == 0) {

                flag = true;

            }


        } while (!flag);

    }

}

