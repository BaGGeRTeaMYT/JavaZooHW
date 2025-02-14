package org.Zoo.Vet;

import org.Zoo.Animals.Animal;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomVet implements VetClinic {

    @Override
    public boolean checkHealth(Animal animal) {
        Random doctorsDegree = new Random();
        int randInt = doctorsDegree.nextInt(100);
        return randInt >= 5;
    }
}
