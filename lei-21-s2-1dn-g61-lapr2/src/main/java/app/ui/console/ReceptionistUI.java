package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistUI implements Runnable {

    public ReceptionistUI()
    {
        // it is a constructor empty
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        try {
            options.add(new MenuItem("Register new Client", new RegisterClientUI()));
        }  catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        options.add(new MenuItem("Register Test", new RegisterTestUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nRecep Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
