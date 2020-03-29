package app.assignments.message;

import app.assignments.message.PingMessage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PingMessageTest {

    @Test
    void getSender() {
        PingMessage pm = new PingMessage();
        assertEquals("ping",pm.getSender());
    }

    @Test
    void getRecipient() {
        PingMessage pm = new PingMessage();
        assertEquals("pong",pm.getRecipient());
    }

    @Test
    void getText() {
        PingMessage pm = new PingMessage();
        assertEquals("Ping has empty body",pm.getText());
    }
}