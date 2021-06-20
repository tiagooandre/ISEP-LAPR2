package app.ui;

import app.ui.console.MainMenuUI;

import java.util.Scanner;

import static java.lang.System.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.println("Use Console? (yes or no)");
        String confirm = sc.next();
        if (confirm.compareToIgnoreCase("yes") == 0) {
            try {
                MainMenuUI menu = new MainMenuUI();
                menu.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(confirm.compareTo("no") == 0){
            MainJAVAFX.main(null);
        }
    }
}
