package org.Zoo.Animals;

public abstract class Predator extends Animal {

    Predator(int food) {
        super(food);
    }

    @Override
    public String describe() {
        return "Это животное питается мясом.";
    }

}
