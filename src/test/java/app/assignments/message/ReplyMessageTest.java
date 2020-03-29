package app.assignments.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplyMessageTest {

    @Test
    void getSender() {
        PingMessage pm = new PingMessage();
        ReplyMessage rm = new ReplyMessage(pm,"my reply");
        assertEquals("ping",rm.getRecipient());
    }

    @Test
    void getRecipient() {
        PingMessage pm = new PingMessage();
        ReplyMessage rm = new ReplyMessage(pm,"my reply");
        assertEquals("pong",rm.getSender());
    }

    @Test
    void getText() {
        PingMessage pm = new PingMessage();
        ReplyMessage rm = new ReplyMessage(pm,"my reply");
        assertEquals("ORIGINAL:\nPing has empty body\nREPLY:\nmy reply", rm.getText());
    }
}