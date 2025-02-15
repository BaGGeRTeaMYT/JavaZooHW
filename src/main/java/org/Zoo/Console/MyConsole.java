package org.Zoo.Console;

import org.Zoo.Console.Commands.CommandCodes;
import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.TokenTypes;
import org.Zoo.Console.Requests.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyConsole extends ConsolePrototype{

    private Processor processor;

    @Autowired
    public MyConsole(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }



    @Override
    public Request readInput() {
        return processor.executeToken(new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_COMMAND.ordinal()));
    }

    @Override
    public String version() {
        return "1.0.0";
    }

}
