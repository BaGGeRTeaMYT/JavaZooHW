package org.Zoo.Console.Commands.ConcreteCommands;

import java.util.Scanner;

public abstract class ChooseAnimalParams implements NonTerminalCommand {

    public ChooseAnimalParams(int animalType) {
        this.animalType = animalType;
    }

    void chooseFoodAmount() {
        System.out.print("Введите количество еды, необходимое этому животному: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals("abort")) {
            food = -1;
        } else {
            food = Integer.parseInt(line);
        }
    }

    public int food;
    public int animalType;
}
