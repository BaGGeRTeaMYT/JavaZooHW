package org.Zoo;

import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.ConcreteCommands.NonTerminalCommand;
import org.Zoo.Console.ConsoleInterface;
import org.Zoo.Console.Processor;
import org.Zoo.Console.Requests.ConcreteRequests.QuitRequest;
import org.Zoo.Console.Requests.ConcreteRequests.ReportRequest;
import org.Zoo.Console.Requests.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMyConsole {
    @Autowired
    private ConsoleInterface console;
    static class StupidProcessor1 implements Processor {

        @Override
        public Request processTerminal(CommandToken token) {
            return new QuitRequest();
        }

        @Override
        public NonTerminalCommand processNonTerminal(CommandToken token) {
            return null;
        }

        @Override
        public Request executeToken(CommandToken token) {
            return processTerminal(token);
        }

        @Override
        public boolean isTerminal(CommandToken token) {
            return true;
        }
    }
    static class StupidProcessor2 implements Processor {

        @Override
        public Request processTerminal(CommandToken token) {
            return new ReportRequest();
        }

        @Override
        public NonTerminalCommand processNonTerminal(CommandToken token) {
            return null;
        }

        @Override
        public Request executeToken(CommandToken token) {
            return processTerminal(token);
        }

        @Override
        public boolean isTerminal(CommandToken token) {
            return true;
        }
    }
    @Test
    void testConsole() {
//        Always creates QuitRequest
        StupidProcessor1 proc1 = new StupidProcessor1();

//        Always creates ReportRequest
        StupidProcessor2 proc2 = new StupidProcessor2();
        console.setProcessor(proc1);
        Assertions.assertInstanceOf(QuitRequest.class, console.readInput());
        console.setProcessor(proc2);
        Assertions.assertInstanceOf(ReportRequest.class, console.readInput());
    }
}
