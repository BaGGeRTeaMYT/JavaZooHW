package org.Zoo.Console.Commands;

public class QuitCommand implements Command {

    @Override
    public CommandToken run() {
        return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.QUIT.ordinal());
    }
}
