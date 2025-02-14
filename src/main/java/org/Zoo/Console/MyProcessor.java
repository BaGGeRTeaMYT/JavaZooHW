package org.Zoo.Console;

import org.Zoo.Console.Commands.*;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements Processor {

    public MyProcessor() {

    }

    @Override
    public Command processToken(CommandToken token) {
        if (token.tokenType == TokenTypes.SET_COMMAND.ordinal()) {
            if (token.value == CommandCodes.CHOOSE_COMMAND.ordinal()) {
                return new ChooseCommand();
            }
            if (token.value == CommandCodes.CHOOSE_ANIMAL.ordinal()) {
                return new ChooseAnimal();
            }
            if (token.value == CommandCodes.QUIT.ordinal()) {
                return new QuitCommand();
            }
        } else if (token.tokenType == TokenTypes.GENERATE_REQUEST.ordinal()) {

        }
        System.out.println("Получен неизвестный токен.");
        return new QuitCommand();
    }

    @Override
    public CommandToken executeCommand(Command cmd) {
        return cmd.run();
    }
}
