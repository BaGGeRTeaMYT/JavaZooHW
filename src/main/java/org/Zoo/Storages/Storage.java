package org.Zoo.Storages;

import org.Zoo.Animals.Animal;
import org.Zoo.Items.Thing;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class Storage implements AnimalStorage, ItemStorage {

    public String version() {
        return "0.0.0";
    }

    @Override
    abstract public String report();

    @Override
    abstract public String kindHerbivores();

    @Override
    abstract public void add(@NotNull Animal animal);

    @Override
    abstract public void add(@NotNull Thing thing);

    abstract public String contents();



    AnimalStorage animalStorage;
    ItemStorage itemStorage;
    int currentNumber;
}
