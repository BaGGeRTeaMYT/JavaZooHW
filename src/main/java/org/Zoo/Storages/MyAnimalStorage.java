package org.Zoo.Storages;

import org.Zoo.Animals.Animal;
import org.Zoo.Animals.Herbivore;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class MyAnimalStorage implements AnimalStorage {

    MyAnimalStorage() {
        this.animals = new Vector<Animal>();
        this.requiredFood = 0;
    }

    @Override
    public String report() {
        return "Животных в зоопарке: " + String.valueOf(animals.size()) + "\n" +
               "Необходимо корма в день: " + String.valueOf(requiredFood) + ".";
    }

    @Override
    public void add(Animal animal) {
        animals.add(animal);
        requiredFood += animal.getFood();
    }

    @Override
    public String kindHerbivores() {
        StringBuilder res = new StringBuilder();
        for (Animal animal : animals) {
            if (animal instanceof Herbivore) {
                if ( ((Herbivore) animal).isKind() ) {
                    res.append(describe(animal));
                }
            }
        }
        return res.toString();
    }

    @Override
    public String contents() {
        StringBuilder res = new StringBuilder();
        boolean firstElement = true;
        for (Animal animal : animals) {
            if (firstElement) {
                res.append("Животные:\n");
                firstElement = false;
            } else {
                res.append("\n");
            }
            String addition = describe(animal);
            res.append(addition);
        }
        return res.toString();
    }

    @Override
    public String version() {
        return "1.0.0";
    }

    @Override
    public String describe(Animal animal) {
        StringBuilder description = new StringBuilder();
        String tmpStr = "\tЖивотное " + animal.getName() + "\n" +
                "\t\tНомер: " + String.valueOf(animal.getNumber()) + "\n" +
                "\t\tТребует еды: " + animal.getFood();
        description.append(tmpStr);
        if (animal instanceof Herbivore) {
            tmpStr = "\n\t\tДоброта: " + ((Herbivore) animal).getKindness();
            description.append(tmpStr);
        }
        return description.toString();
    }

    private final Vector<Animal> animals;
    int requiredFood;
}
