package org.Zoo.Console;

import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.ConcreteCommands.NTCommandPrototype;
import org.Zoo.Console.Requests.Request;

public interface Processor {

    Request processTerminal(CommandToken token);
    NTCommandPrototype processNonTerminal(CommandToken token);
    Request executeToken(CommandToken token );
    boolean notTerminal(CommandToken token);
}
