package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClinicalTecUI implements Runnable {

    public ClinicalTecUI()
    {
        // it is a constructor empty
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register Test Results", new RegisterTestResultUI()));
        try {
            options.add(new MenuItem("View Clients Test",new CheckResultUI()));
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nCCT Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}