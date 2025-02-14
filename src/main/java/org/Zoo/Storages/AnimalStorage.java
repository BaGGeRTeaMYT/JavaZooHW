package org.Zoo.Storages;

import org.Zoo.Animals.Animal;

import java.util.List;

public interface AnimalStorage {
    String report();
    void addAnimal(Animal animal);
    List<Animal> kindHerbivores();
    String contents();
}
