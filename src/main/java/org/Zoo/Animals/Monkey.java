package org.Zoo.Animals;

public class Monkey extends Herbivore {

    public Monkey(int food, int number, int kindness) {
        super(food, number, kindness);
    }

    @Override
    public String describe() {
        return "Вообще обезьяны всеядные, но для простоты будем кормить их только травами.";
    }

    @Override
    public String getName() {
        return "Обезьяна";
    }
}
