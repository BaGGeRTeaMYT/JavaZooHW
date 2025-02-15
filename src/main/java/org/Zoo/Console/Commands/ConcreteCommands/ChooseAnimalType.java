package org.Zoo.Console.Commands.ConcreteCommands;

import org.Zoo.Animals.AnimalTypes;
import org.Zoo.Console.Commands.CommandCodes;
import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.TokenTypes;
import org.springframework.stereotype.Component;

@Component
public class ChooseAnimalType extends NTCommandPrototype {
    public ChooseAnimalType() {}

    @Override
    public CommandToken run() {
        printer.print("Введите название животного: ");
        String animal = reader.getLine();
        switch (animal.toLowerCase()) {
            case "тигр":
            case "tiger":
                return new CommandToken(TokenTypes.SET_COMMAND.ordinal(),
                        CommandCodes.CHOOSE_ANIMAL_PARAMS.ordinal(),
                        new int[]{AnimalTypes.TIGER.ordinal(), 0});
            case "обезьяна":
            case "monkey":
                return new CommandToken(TokenTypes.SET_COMMAND.ordinal(),
                        CommandCodes.CHOOSE_ANIMAL_PARAMS.ordinal(),
                        new int[]{AnimalTypes.MONKEY.ordinal(), 0});
            case "заяц":
            case "rabbit":
                return new CommandToken(TokenTypes.SET_COMMAND.ordinal(),
                        CommandCodes.CHOOSE_ANIMAL_PARAMS.ordinal(),
                        new int[]{AnimalTypes.RABBIT.ordinal(), 0});
            case "волк":
            case "wolf":
                return new CommandToken(TokenTypes.SET_COMMAND.ordinal(),
                        CommandCodes.CHOOSE_ANIMAL_PARAMS.ordinal(),
                        new int[]{AnimalTypes.WOLF.ordinal(), 0});
            case "abort":
                return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_COMMAND.ordinal());
            default:
                printer.println("Неопознанное животное: \"" + animal + "\"");
        }
        return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_ANIMAL.ordinal());
    }
}
