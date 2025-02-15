package org.Zoo;

import org.Zoo.Console.MyConsole;
import org.Zoo.Storages.MyStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class start {
    public static void main( String[] args ) {
        ApplicationContext context = SpringApplication.run(start.class, args);
        ZooCoordinator zoo = context.getBean(ZooCoordinator.class);
        zoo.coordinate();
    }
}
