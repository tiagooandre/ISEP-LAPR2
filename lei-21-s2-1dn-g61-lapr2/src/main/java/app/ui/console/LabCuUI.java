package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Miguel Chen
 */

public class LabCuUI implements Runnable{


        public LabCuUI()
        {
            // it is a constructor empty
        }

        public void run()
        {
            List<MenuItem> options = new ArrayList<>();
            try {
                options.add(new MenuItem("Validate Work",new ValidatingWorkUI()));
            }  catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            options.add(new MenuItem("Add tests from file",new TestFileUI()));


            int option=0;
            do
            {
                option = Utils.showAndSelectIndex(options, "\n\nLabCu Menu:");

                if ( (option >= 0) && (option < options.size()))
                {
                    options.get(option).run();
                }
            }
            while (option != -1 );
        }
}
