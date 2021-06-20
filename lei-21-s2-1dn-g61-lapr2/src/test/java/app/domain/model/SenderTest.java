package app.domain.model;

import org.junit.Test;

public class SenderTest {

    @Test
    public void senderTest(){
        Sender sender = new Sender();
        sender.sender("ola");
    }
}
