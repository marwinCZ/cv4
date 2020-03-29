package app.assignments.writer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClassWriter {

    public ConfigurationClassWriter(){}

    @Bean
    public ListWriter listWriter(){
        return new ListWriter();
    }
    @Bean
    public StdoutWriter stdoutWriter(){
        return new StdoutWriter();
    }
}
