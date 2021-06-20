package app.ui.console;

import app.controller.SerialController;
import app.domain.model.AutoReportNHS;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MainMenuUI {

    SerialController sp;

    public MainMenuUI()
    {
        // it is a constructor empty
    }

    public void run() throws IOException, ClassNotFoundException {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Do Login", new AuthUI()));
        options.add(new MenuItem("Know the Development Team",new DevTeamUI()));
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
        AutoReportNHS.timer.cancel();
        sp = new SerialController();
        sp.serializeList();
    }


}
