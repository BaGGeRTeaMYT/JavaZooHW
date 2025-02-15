package org.Zoo.Console.Commands.ConcreteCommands;

import org.Zoo.Console.Commands.CommandCodes;
import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Commands.TokenTypes;
import org.Zoo.Console.Requests.RequestTypes;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ChooseCommand implements NonTerminalCommand {

    public ChooseCommand() {}

    @Override
    public CommandToken run() {
        System.out.println("Ожидаю команду, введите h для получения списка команд.");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        command = command.toLowerCase();
        switch (command) {
            case "h":
                System.out.println("Чтобы добавить животное, введите add_animal;\n" +
                                   "Чтобы добавить предмет, введите add_item;\n" +
                                   "Чтобы получить отчёт по количеству животных и потребляемом ими количестве еды, введите report;\n" +
                                   "Чтобы получить список животных, доступных для контактного зоопарка, введите list;\n" +
                                   "Чтобы получить содержимое хранилищ с инвентаризационными номерами, введите all;\n" +
                                   "Чтобы завершить работу, введите quit.");
                return new CommandToken((TokenTypes.SET_COMMAND.ordinal()), CommandCodes.CHOOSE_COMMAND.ordinal());
            case "add_animal":
                return new CommandToken((TokenTypes.SET_COMMAND.ordinal()), CommandCodes.CHOOSE_ANIMAL.ordinal());
            case "add_item":
                return new CommandToken((TokenTypes.SET_COMMAND.ordinal()), CommandCodes.CHOOSE_ITEM.ordinal());
            case "quit":
                return new CommandToken((TokenTypes.GENERATE_REQUEST.ordinal()), RequestTypes.QUIT.ordinal());
            case "report":
                return new CommandToken((TokenTypes.GENERATE_REQUEST.ordinal()), RequestTypes.REPORT.ordinal());
            case "list":
                return new CommandToken((TokenTypes.GENERATE_REQUEST.ordinal()), RequestTypes.LIST.ordinal());
            case "all":
                return new CommandToken((TokenTypes.GENERATE_REQUEST.ordinal()), RequestTypes.ENUMERATION.ordinal());
            default:
                System.out.println("Неизвестная команда: " + command);
                return new CommandToken((TokenTypes.SET_COMMAND.ordinal()), CommandCodes.CHOOSE_COMMAND.ordinal());
        }
    }
}
