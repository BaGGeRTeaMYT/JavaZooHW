package org.Zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class start {
    public static void main( String[] args ) {
        ApplicationContext context = SpringApplication.run(start.class, args);
    }
}
