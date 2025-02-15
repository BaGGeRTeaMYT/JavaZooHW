package org.Zoo.Animals;

import org.Zoo.RequiredInterfaces.IAlive;
import org.Zoo.RequiredInterfaces.IInventory;

public abstract class Animal implements IAlive, IInventory {
    public int getFood() {
        return food;
    }
    public int getNumber() {
        return number;
    }

    public static boolean isHerbivore(int animalType) {
        return (animalType == AnimalTypes.MONKEY.ordinal() || animalType == AnimalTypes.RABBIT.ordinal());
    }

    public static boolean isPredator(int animalType) {
        return (animalType == AnimalTypes.WOLF.ordinal() || animalType == AnimalTypes.TIGER.ordinal());
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public
    abstract String describe();

    Animal(int food) {
        this.food = food;
        number = -1;
    }
    final int food;
    protected int number;

}
