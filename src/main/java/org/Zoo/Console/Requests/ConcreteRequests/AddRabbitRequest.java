package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Animals.Rabbit;
import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;

public class AddRabbitRequest extends Request {

    public AddRabbitRequest(int food, int kindness) {
        super(food, kindness);
    }

    @Override
    public int execute(RequestableType smth) {
        Rabbit rabbit = new Rabbit(value, additionalInfo);
        String loggingString = "Заяц не прошёл проверку здоровья.";
        if (smth.vet.checkHealth(rabbit)) {
            smth.storage.add(rabbit);
            loggingString = "Заяц добавлен в зоопарк.";
        }
        printer.println(loggingString);
        return 0;
    }
}
