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

    public
    abstract String describe();

    Animal(int food, int number) {
        this.food = food;
        this.number = number;
    }
    final int food;
    final int number;

}
