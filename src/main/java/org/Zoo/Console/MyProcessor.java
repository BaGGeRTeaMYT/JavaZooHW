package org.Zoo.Console;

import org.Zoo.Animals.Animal;
import org.Zoo.Console.Commands.*;
import org.Zoo.Console.Commands.ConcreteCommands.*;
import org.Zoo.Console.Requests.*;
import org.Zoo.Console.Requests.RequestGenerator.MyRequestGen;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements Processor {

    public MyProcessor() {

    }

    @Override
    public Request processTerminal(CommandToken token) {
        MyRequestGen gen = new MyRequestGen();
        return gen.generate(token);
    }

    @Override
    public NTCommandPrototype processNonTerminal(CommandToken token) {
        if (token.value == CommandCodes.CHOOSE_COMMAND.ordinal()) {
            return new ChooseCommand();
        }
        if (token.value == CommandCodes.CHOOSE_ANIMAL.ordinal()) {
            return new ChooseAnimalType();
        }
        if (token.value == CommandCodes.CHOOSE_ITEM.ordinal()) {
            return new ChooseItemType();
        }
        if (token.value == CommandCodes.CHOOSE_ANIMAL_PARAMS.ordinal()) {
            if (Animal.isHerbivore(token.additionalInfo[0])) {
                return new ChooseHerbivoreParams(token.additionalInfo[0]);
            }
            if (Animal.isPredator(token.additionalInfo[0])) {
                return new ChoosePredatorParams(token.additionalInfo[0]);
            }
        }
        System.out.println("Получен неизвестный нетерминальный токен.");
        return new ChooseCommand();
    }

    @Override
    public Request executeToken(CommandToken token) {
        while (notTerminal(token)) {
            token = processNonTerminal(token).run();
        }
        return processTerminal(token);
    }

    @Override
    public boolean notTerminal(CommandToken token) {
        if (token.tokenType == TokenTypes.SET_COMMAND.ordinal()) {
            return true;
        } else if (token.tokenType == TokenTypes.GENERATE_REQUEST.ordinal()) {
            return false;
        }
        throw new RuntimeException("Получен неизвестный токен");
    }
}
