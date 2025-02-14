package org.Zoo.Animals;

public class Wolf extends Predator {
    public Wolf(int food, int number) {
        super(food, number);
    }

    @Override
    public String describe() {
        return "Работа не волк, работа - ворк, волк - ходить.";
    }

    @Override
    public String getName() {
        return "Волк";
    }
}
