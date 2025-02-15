package org.Zoo.Storages;

import org.Zoo.Animals.Animal;

public interface AnimalStorage {
    String report();
    void add(Animal animal);
    String kindHerbivores();
    String contents();
    String version();
    String describe(Animal animal);
}
