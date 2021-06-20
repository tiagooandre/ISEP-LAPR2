package app.domain.model;

import com.nhs.report.*;

public class Sender {
    /**
     * Constructor
     */
    public Sender(){
        //this is a constructor empty for this class
    }
    /**
     * Sends report to the nhs through nhs api
     * @param text
     */
    public void sender(String text){
        Report2NHS.writeUsingFileWriter(text);
    }
}
