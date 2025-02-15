package org.Zoo.Utility;

import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.ConcreteCommands.NTCommandPrototype;
import org.Zoo.Console.Processor;
import org.Zoo.Console.Requests.ConcreteRequests.QuitRequest;
import org.Zoo.Console.Requests.Request;

public class StupidProcessor1 implements Processor {

    @Override
    public Request processTerminal(CommandToken token) {
        return new QuitRequest();
    }

    @Override
    public NTCommandPrototype processNonTerminal(CommandToken token) {
        return null;
    }

    @Override
    public Request executeToken(CommandToken token) {
        return processTerminal(token);
    }

    @Override
    public boolean notTerminal(CommandToken token) {
        return false;
    }
}
