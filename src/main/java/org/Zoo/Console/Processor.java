package org.Zoo.Console;

import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.Command;

public interface Processor {

    Command processToken(CommandToken token);
    CommandToken executeCommand(Command cmd);
}
