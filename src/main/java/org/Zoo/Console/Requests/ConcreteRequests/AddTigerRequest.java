package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Animals.Tiger;
import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;

public class AddTigerRequest extends Request {
    public AddTigerRequest(int food) {
        super(food);
    }

    @Override
    public int execute(RequestableType smth) {
        Tiger tiger = new Tiger(value);
        String loggingString = "Тигр не прошёл проверку здоровья.";
        if (smth.vet.checkHealth(tiger)) {
            smth.storage.add(tiger);
            loggingString = "Тигр добавлен в зоопарк.";
        }
        printer.println(loggingString);
        return 0;
    }
}
