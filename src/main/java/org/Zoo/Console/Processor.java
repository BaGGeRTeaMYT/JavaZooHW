package org.Zoo.Console;

import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.ConcreteCommands.NonTerminalCommand;
import org.Zoo.Console.Requests.Request;

public interface Processor {

    Request processTerminal(CommandToken token);
    NonTerminalCommand processNonTerminal(CommandToken token);
    Request executeToken(CommandToken token );
    boolean isTerminal(CommandToken token);
}
