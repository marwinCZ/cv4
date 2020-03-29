package app.assignments.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Configuration
@Import(ConfigurationClassMessage.class)
public class ReplyMessage implements Message {

    @Autowired
    @Qualifier("pingMessage")
    private Message original;
    private String reply;

    @Autowired
    public ReplyMessage(@Qualifier("pingMessage")Message original,@Value("some reply") String reply) {
        this.original = original;
        this.reply = reply;
    }

    public ReplyMessage(){}

    public String getSender() {
        return original.getRecipient();
    }

    public String getRecipient() {
        return original.getSender();
    }

    public String getText() {
        return "ORIGINAL:\n" + original.getText() + "\nREPLY:\n" + reply;
    }

    @PostConstruct
    public void potCons()  {
        System.out.println("ReplyMessage class is initialized");
    }
    @PreDestroy
    public void preDest()  {
        System.out.println("ReplyMessage class is destroyed");
    }

}
