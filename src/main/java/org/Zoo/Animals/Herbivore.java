package org.Zoo.Animals;

public abstract class Herbivore extends Animal {

    Herbivore(int food, int kindness) {
        super(food);
        this.kindness = kindness;
    }

    public int getKindness() {
        return kindness;
    }

    public boolean isKind() {
        return kindness >= 5;
    }

    @Override
    public String describe() {
        return "Это животное питается фруктами и травами.";
    }

    int kindness;
}
