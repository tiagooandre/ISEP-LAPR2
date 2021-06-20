package app.ui.console.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Utils {

    private Utils(){
        //this is a empty constructor for this class
    }
    public static String readLineFromConsole(String prompt)
    {
        try
        {
            out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static int readIntegerFromConsole(String prompt)
    {
        do
        {
            try
            {
                String input = readLineFromConsole(prompt);

                return Integer.parseInt(input);
            } catch (NumberFormatException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    public static double readDoubleFromConsole(String prompt)
    {
        do
        {
            try
            {
                String input = readLineFromConsole(prompt);

                return Double.parseDouble(input);
            } catch (NumberFormatException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    public static Date readDateFromConsole(String prompt)
    {
        do
        {
            try
            {
                String strDate = readLineFromConsole(prompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                return df.parse(strDate);
            } catch (ParseException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    public static boolean confirm(String message) {
        String input;
        do {
            input = Utils.readLineFromConsole("\n" + message + "\n");
        } while (!Objects.requireNonNull(input).equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

        return input.equalsIgnoreCase("yes");
    }

    public static Object showAndSelectOne(List<?> list, String header)
    {
        showList(list,header);
        return selectsObject(list);
    }
    public static int showAndSelectIndex(List<?> list, String header)
    {
        showList(list,header);
        return selectsIndex(list);
    }
    public static void showList(List<?> list, String header)
    {
        out.println(header);

        int index = 0;
        for (Object o : list)
        {
            index++;

            out.println(index + ". " + o.toString());
        }
        out.println("");
        out.println("0 - Cancel");
    }

    public static  Object selectsObject(List<?> list)
    {
        String input;
        Integer value;
        do
        {
            input = Utils.readLineFromConsole("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0)
        {
            return null;
        } else
        {
            return list.get(value - 1);
        }
    }

    public static int selectsIndex(List<?> list)
    {
        String input;
        Integer value;
        do
        {
            input = Utils.readLineFromConsole("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        return value - 1;
    }
}
