package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Animals.Monkey;
import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;

public class AddMonkeyRequest extends Request {

    public AddMonkeyRequest(int food, int kindness) {
        super(food, kindness);
    }

    @Override
    public int execute(RequestableType smth) {
        Monkey monkey = new Monkey(value, additionalInfo);
        String loggingString = "Обезьяна не прошла проверку здоровья.";
        if (smth.vet.checkHealth(monkey)) {
            smth.storage.add(monkey);
            loggingString = "Обезьяна добавлена в зоопарк.";
        }
        printer.println(loggingString);
        return 0;
    }
}
