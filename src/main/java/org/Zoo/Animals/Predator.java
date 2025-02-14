package org.Zoo.Animals;

public abstract class Predator extends Animal {

    Predator(int food, int number) {
        super(food, number);
    }

    @Override
    public String describe() {
        return "Это животное питается мясом.";
    }

}
