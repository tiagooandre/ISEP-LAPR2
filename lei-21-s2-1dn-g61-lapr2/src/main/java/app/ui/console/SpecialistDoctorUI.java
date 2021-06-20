package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpecialistDoctorUI implements Runnable {
    public SpecialistDoctorUI()
    {
        // it is a constructor empty
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        try {
            options.add(new MenuItem("Write Report",new MakeReportUI()));
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        int option=0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nSpecialistDoctor Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}


