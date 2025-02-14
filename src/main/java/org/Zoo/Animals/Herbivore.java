package org.Zoo.Animals;

public abstract class Herbivore extends Animal {

    Herbivore(int food, int number, int kindness) {
        super(food, number);
        this.kindness = kindness;
    }

    public int getKindness() {
        return kindness;
    }

    @Override
    public String describe() {
        return "Это животное питается фруктами и травами.";
    }

    int kindness;
}
