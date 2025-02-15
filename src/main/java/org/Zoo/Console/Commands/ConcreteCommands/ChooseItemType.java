package org.Zoo.Console.Commands.ConcreteCommands;

import org.Zoo.Console.Commands.CommandCodes;
import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.TokenTypes;
import org.Zoo.Console.Requests.RequestTypes;
import org.Zoo.Items.ItemTypes;

import java.util.Scanner;

public class ChooseItemType implements NonTerminalCommand {

    @Override
    public CommandToken run() {
        System.out.print("Введите название предмета: ");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
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
                System.out.println("Неопознанный предмет: " + item);
        }
        return new CommandToken(TokenTypes.SET_COMMAND.ordinal(), CommandCodes.CHOOSE_ITEM.ordinal());
    }
}
