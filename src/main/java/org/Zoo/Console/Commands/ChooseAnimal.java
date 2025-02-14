package org.Zoo.Console.Commands;

import java.util.Scanner;

public class ChooseAnimal implements Command {

    @Override
    public CommandToken run() {
        System.out.print("Введите название животного: ");
        Scanner scanner = new Scanner(System.in);
        String animal = scanner.nextLine();
        switch (animal.toLowerCase()) {
            case "тигр":
            case "tiger":
                return null;
            case "обезьяна":
            case "monkey":
                return null;
            default:
                System.out.println("Неопознанное животное: " + animal);
        }
        return null;
    }
}
