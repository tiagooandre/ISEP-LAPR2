package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MedicalLabTechnicianUI implements Runnable{

    public MedicalLabTechnicianUI()
    {
        // it is a constructor empty
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Record new Sample", new RecordSampleUI()));


        int option=0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMedical Lab Technician Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );

    }
}

