package app.assignments.app;

import app.assignments.message.ConfigurationClassMessage;
import app.assignments.message.Message;
import app.assignments.message.PingMessage;
import app.assignments.message.ReplyMessage;
import app.assignments.writer.ConfigurationClassWriter;
import app.assignments.writer.ListWriter;
import app.assignments.writer.Writer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("app.assignments")
@Import({ConfigurationClassMessage.class, ConfigurationClassWriter.class, ReplyMessage.class})
public class Main {

    public Main() {}

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Message ping = (Message) context.getBean("pingMessage");
        Message hello = (Message) context.getBean("customMessage");
        Message pingReply = (Message) context.getBean("replyMessage");

        Writer stdoutWriter = (Writer) context.getBean("stdoutWriter");
        Writer listWriter = (Writer) context.getBean("listWriter");
        stdoutWriter.write(ping);
        stdoutWriter.write(hello);
        stdoutWriter.write(pingReply);


        listWriter.write(ping);
        ((ListWriter) listWriter).listWrittenMessages().forEach(stdoutWriter::write);

    }

}
