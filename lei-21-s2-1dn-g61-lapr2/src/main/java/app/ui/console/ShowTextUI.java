package app.ui.console;

import org.apache.commons.lang3.StringUtils;

import static java.lang.System.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class ShowTextUI implements Runnable{

    private String text;
    public ShowTextUI(String text)
    {
        if (StringUtils.isBlank(text))
            throw new IllegalArgumentException("ShowTextUI does not support null or empty text");

        this.text = text;
    }
    public void run()
    {
        out.println("\n");
        out.println(this.text);
        out.println("\n");
    }
}
