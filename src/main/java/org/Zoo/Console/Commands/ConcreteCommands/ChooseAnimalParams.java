package org.Zoo.Console.Commands.ConcreteCommands;

public abstract class ChooseAnimalParams extends NTCommandPrototype {

    public ChooseAnimalParams(int animalType) {
        this.animalType = animalType;
    }

    void chooseFoodAmount() {
        printer.print("Введите количество еды, необходимое этому животному: ");
        String line = reader.getLine();
        if (line.equals("abort")) {
            food = -1;
        } else {
            food = Integer.parseInt(line);
        }
    }

    public int food;
    public int animalType;
}
