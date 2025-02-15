package org.Zoo.Animals;

public class Tiger extends Predator {

    public Tiger(int food) {
        super(food);
    }

    @Override
    public String describe() {
        return "Тигор полосатый.";
    }

    @Override
    public String getName() {
        return "Тигр";
    }
}
