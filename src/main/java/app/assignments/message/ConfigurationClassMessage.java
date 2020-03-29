package app.assignments.message;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationClassMessage {

    public ConfigurationClassMessage(){}

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PingMessage pingMessage(){return new PingMessage();}

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CustomMessage customMessage(){
        return new CustomMessage("sender", "recipient","Some custom text");
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ReplyMessage replyMessage(){
        return new ReplyMessage();
    }
}
