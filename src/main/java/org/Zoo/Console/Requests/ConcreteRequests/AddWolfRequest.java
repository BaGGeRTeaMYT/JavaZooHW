package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Animals.Wolf;
import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;

public class AddWolfRequest extends Request {

    public AddWolfRequest(int food) {
        super(food);
    }

    @Override
    public int execute(RequestableType smth) {
        Wolf wolf = new Wolf(value);
        String loggingString = "Волк не прошёл проверку здоровья.";
        if (smth.vet.checkHealth(wolf)) {
            smth.storage.add(wolf);
            loggingString = "Волк добавлен в зоопарк.";
        }
        System.out.println(loggingString);
        return 0;
    }
}
