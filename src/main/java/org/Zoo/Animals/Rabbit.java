package org.Zoo.Animals;

public class Rabbit extends Herbivore {
    public Rabbit(int food, int kindness) {
        super(food, kindness);
    }

    @Override
    public String describe() {
        return "Зайцы едят только растительную пищу.";
    }

    @Override
    public String getName() {
        return "Заяц";
    }
}
