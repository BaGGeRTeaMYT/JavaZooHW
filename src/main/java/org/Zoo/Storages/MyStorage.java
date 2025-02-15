package org.Zoo.Storages;

import org.Zoo.Animals.Animal;
import org.Zoo.Items.Thing;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyStorage extends Storage {

    private final AnimalStorage animalStorage;
    private final ItemStorage itemStorage;

    @Autowired
    MyStorage(AnimalStorage animalStorage, ItemStorage itemStorage) {
        this.animalStorage = animalStorage;
        this.itemStorage = itemStorage;
        this.currentNumber = 0;
    }

    @Override
    public String version() {
        return "Версия хранилища животных " + animalStorage.version() + "\n" +
               "Версия хранилища предметов " + itemStorage.version();
    }

    @Override
    public String describe(Thing thing) {
        return itemStorage.describe(thing);
    }

    @Override
    public String describe(Animal animal) {
        return animalStorage.describe(animal);
    }

    @Override
    public String report() {
        return animalStorage.report();
    }

    @Override
    public String kindHerbivores() {
        return animalStorage.kindHerbivores();
    }

    @Override
    public void add(@NotNull Animal animal) {
        animal.setNumber(currentNumber++);
        animalStorage.add(animal);
    }

    @Override
    public void add(@NotNull Thing thing) {
        thing.setNumber(currentNumber++);
        itemStorage.add(thing);
    }

    @Override
    public String contents() {
        return animalStorage.contents()  + "\n" + itemStorage.contents();
    }
}
