package org.Zoo.Storages;

import org.Zoo.Animals.Animal;
import org.Zoo.Animals.Herbivore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Component
public class MyAnimalStorage implements AnimalStorage {

    @Override
    public String report() {
        return "В зоопарке сейчас " + String.valueOf(animals.size()) + "\n" +
               "Им нужно " + String.valueOf(requiredFood) + " единиц корма в день.";
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
        requiredFood += animal.getFood();
    }

    @Override
    public List<Animal> kindHerbivores() {
        List<Animal> list = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Herbivore) {
                if ( ((Herbivore) animal).getKindness() >= 5) {
                    list.add(animal);
                }
            }
        }
        return list;
    }

    @Override
    public String contents() {
        StringBuilder res = new StringBuilder();
        for (Animal animal : animals) {
            String tmpStr = animal.getName() + " с номером " + String.valueOf(animal.getNumber()) + "\n";
            res.append(tmpStr);
        }
        return res.toString();
    }

    Vector<Animal> animals;
    int requiredFood;
}
