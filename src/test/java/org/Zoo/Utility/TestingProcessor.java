package org.Zoo.Utility;

import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.ConcreteCommands.NTCommandPrototype;
import org.Zoo.Console.MyProcessor;
import org.Zoo.Console.Printers.Printer;
import org.Zoo.Console.Readers.ConsoleReader;
import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestGenerator.RequestGenerator;

public class TestingProcessor extends MyProcessor {

    public TestingProcessor(ConsoleReader reader, RequestGenerator requestGen, Printer commandPrinter) {
        this.reader = reader;
        this.requestGen = requestGen;
        this.commandPrinter = commandPrinter;
    }

    public TestingProcessor(ConsoleReader reader, RequestGenerator requestGen) {
        this.reader = reader;
        this.requestGen = requestGen;
        this.commandPrinter = new EmptyPrinter();
    }

    public TestingProcessor() {
        this.reader = new FakeReader();
        this.requestGen = new FakeRequestGen();
        this.commandPrinter = new EmptyPrinter();
    }

    @Override
    public Request processTerminal(CommandToken token) {
        return requestGen.generate(token);
    }

    public void setCommandPrinter(Printer printer) {
        this.commandPrinter = printer;
    }

    @Override
    public NTCommandPrototype processNonTerminal(CommandToken token) {
        NTCommandPrototype cmd = super.processNonTerminal(token);
        cmd.setReader(reader);
        cmd.setPrinter(commandPrinter);
        return cmd;
    }

    @Override
    public Request executeToken(CommandToken token) {
        while (notTerminal(token)) {
            token = processNonTerminal(token).run();
        }
        return processTerminal(token);
    }

    @Override
    public boolean notTerminal(CommandToken token) {
        return super.notTerminal(token);
    }
    private final ConsoleReader reader;
    private final RequestGenerator requestGen;
    private Printer commandPrinter;
}
