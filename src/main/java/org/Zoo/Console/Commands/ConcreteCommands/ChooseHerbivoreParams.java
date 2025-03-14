package org.Zoo.Console.Commands.ConcreteCommands;

import org.Zoo.Console.Commands.CommandCodes;
import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.TokenTypes;
import org.Zoo.Console.Requests.RequestTypes;

public class ChooseHerbivoreParams extends ChooseAnimalParams {

    public ChooseHerbivoreParams(int animalType) {
        super(animalType);
    }

    @Override
    public CommandToken run() {
        chooseFoodAmount();
        if (food < 0) {
            return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_COMMAND.ordinal());
        }
        printer.print("Введите доброту этого животного: ");
        int kindness;
        String line = reader.getLine();
        if (line.equals("abort")) {
            return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_COMMAND.ordinal());
        } else {
            kindness = Integer.parseInt(line);
        }
        return new CommandToken(TokenTypes.GENERATE_REQUEST.ordinal(), RequestTypes.ADD_ANIMAL.ordinal(), new int[]{animalType, food, kindness});
    }
}
