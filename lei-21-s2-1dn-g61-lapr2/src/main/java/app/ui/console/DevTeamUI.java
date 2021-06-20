package app.ui.console;

import static java.lang.System.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class DevTeamUI implements Runnable{

    public DevTeamUI()
    {
        // it is a constructor empty
    }
    public void run()
    {
        out.println("\n");
        out.print("Development Team:\n");
        out.print("\t David Araujo - 1200609@isep.ipp.pt \n");
        out.print("\t Goncalo Familiar - 1181213@isep.ipp.pt \n");
        out.print("\t Marisa Pereira - 1191596@isep.ipp.pt \n");
        out.print("\t Miguel Chen - 1190897@isep.ipp.pt \n");
        out.print("\t Renan Oliveira - 1200623@isep.ipp.pt \n");
        out.print("\t Tiago Pinto - 1200626@isep.ipp.pt \n");
        out.println("\n");
    }
}
