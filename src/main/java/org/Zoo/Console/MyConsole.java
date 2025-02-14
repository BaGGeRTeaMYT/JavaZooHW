package org.Zoo.Console;

import org.Zoo.Console.Commands.*;
import org.Zoo.Console.Requests.AddMonkeyRequest;
import org.Zoo.Console.Requests.Request;
import org.springframework.stereotype.Component;

@Component
public class MyConsole extends ConsolePrototype{

    public MyConsole() {

    }

    @Override
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public Request readInput() {
        Command cmd = new ChooseCommand();
        CommandToken token = processor.executeCommand(cmd);
        return new AddMonkeyRequest(7, 2);
    }

}
