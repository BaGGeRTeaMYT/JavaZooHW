package org.Zoo.Animals;

public class Monkey extends Herbivore {

    public Monkey(int food, int kindness) {
        super(food, kindness);
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
