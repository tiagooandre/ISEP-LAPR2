package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{

    public AdminUI()
    {
        // it is a constructor empty
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register new Test Type", new CreateTestTypeUI()));
        options.add(new MenuItem("Register Laboratory", new RegiterClinicalAnalysisLaboratoryUI()));
        options.add(new MenuItem("Register new Parameter Category", new CreateParameterCategoryUI()));
        options.add(new MenuItem("Register new Employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("Register new Parameter", new CreateParameterUI()));
        try {
            options.add(new MenuItem("Send Report to NHS",new ManualReportUI()));
        }  catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        int option=0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
