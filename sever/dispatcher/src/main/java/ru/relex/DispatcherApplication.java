package ru.relex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DispatcherApplication {
    public static void main(String[] args) {
	    SpringApplication.run(DispatcherApplication.class);
    }
}
