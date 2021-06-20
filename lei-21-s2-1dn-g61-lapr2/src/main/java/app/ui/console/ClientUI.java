package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable{
    public ClientUI()
    {
        // it is a constructor empty
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();

        try {
            options.add(new MenuItem("Change my personal information", new ClientInformationUI()));
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        try {
            options.add(new MenuItem("View my results from on test", new ViewClientResultsUI()));
        }  catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        int option=0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nClient Menu:");

            if ( (option >= 0) && (option < options.size()))
            {

                options.get(option).run();
            }
        }
        while (option != -1 );

    }
}
