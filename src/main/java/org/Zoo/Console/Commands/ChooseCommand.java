package org.Zoo.Console.Commands;

import java.util.Scanner;

public class ChooseCommand implements Command {

    public ChooseCommand() {}

    @Override
    public CommandToken run() {
        System.out.println("Ожидаю команду, введите h для списка команд.");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        switch (command) {
            case "h":
                System.out.println("Чтобы добавить животное, введите add\nЧтобы завершить работу, введите quit.");
                return new CommandToken((TokenTypes.SET_COMMAND.ordinal()), CommandCodes.CHOOSE_COMMAND.ordinal());
            case "quit":
                return new CommandToken((TokenTypes.SET_COMMAND.ordinal()), CommandCodes.QUIT.ordinal());
            case "add":
                return new CommandToken((TokenTypes.SET_COMMAND.ordinal()), CommandCodes.ADD.ordinal());
            default:
                System.out.println("Неизвестная команда: " + command);
                return new CommandToken((TokenTypes.SET_COMMAND.ordinal()), CommandCodes.CHOOSE_COMMAND.ordinal());
        }
    }
}
