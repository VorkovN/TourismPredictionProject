package ru.relex.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.relex.model.RabbitQueue.*;

//@EnableScheduling
@Configuration
public class RabbitConfiguration {
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue gui2server() {
        return new Queue(GUI_2_SERVER);
    }

    @Bean
    public Queue server2qui() {
        return new Queue(SERVER_2_GUI);
    }
    @Bean
    public Queue server2ml() {
        return new Queue(SERVER_2_ML);
    }
    @Bean
    public Queue ml2server() {
        return new Queue(ML_2_SERVER);
    }
}
