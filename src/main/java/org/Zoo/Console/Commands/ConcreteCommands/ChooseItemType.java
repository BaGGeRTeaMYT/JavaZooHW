package org.Zoo.Console.Commands.ConcreteCommands;

import org.Zoo.Console.Commands.CommandCodes;
import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.TokenTypes;
import org.Zoo.Console.Requests.RequestTypes;
import org.Zoo.Items.ItemTypes;

public class ChooseItemType extends NTCommandPrototype {

    @Override
    public CommandToken run() {
        printer.print("Введите название предмета: ");
        String item = reader.getLine();
        switch (item.toLowerCase()) {
            case "компьютер":
            case "computer":
                return new CommandToken(TokenTypes.GENERATE_REQUEST.ordinal(),
                        RequestTypes.ADD_ITEM.ordinal(),
                        new int[]{ItemTypes.COMPUTER.ordinal(), 0});
            case "стол":
            case "table":
                return new CommandToken(TokenTypes.GENERATE_REQUEST.ordinal(),
                        RequestTypes.ADD_ITEM.ordinal(),
                        new int[]{ItemTypes.TABLE.ordinal(), 0});
            case "abort":
                return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_COMMAND.ordinal());
            default:
                printer.println("Неопознанный предмет: " + item);
        }
        return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_ITEM.ordinal());
    }
}
