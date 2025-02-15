package org.Zoo.Console.Commands.ConcreteCommands;

import org.Zoo.Console.Commands.CommandCodes;
import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.TokenTypes;
import org.Zoo.Console.Requests.RequestTypes;

public class ChoosePredatorParams extends ChooseAnimalParams {
    public ChoosePredatorParams(int animalType) {
        super(animalType);
    }

    @Override
    public CommandToken run() {
        chooseFoodAmount();
        if (food < 0) {
            return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_COMMAND.ordinal());
        }
        return new CommandToken(TokenTypes.GENERATE_REQUEST.ordinal(), RequestTypes.ADD_ANIMAL.ordinal(), new int[]{animalType, food});
    }
}
