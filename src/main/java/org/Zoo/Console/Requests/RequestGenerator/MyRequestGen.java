package org.Zoo.Console.Requests.RequestGenerator;

import org.Zoo.Animals.AnimalTypes;
import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Requests.*;
import org.Zoo.Console.Requests.ConcreteRequests.*;
import org.Zoo.Items.ItemTypes;
import org.springframework.stereotype.Component;

@Component
public class MyRequestGen implements RequestGenerator {

    @Override
    public Request generate(CommandToken token) {
        if (token.value == RequestTypes.ADD_ANIMAL.ordinal()) {
            int animal = token.additionalInfo[0];
            if (animal == AnimalTypes.MONKEY.ordinal()) {
                return new AddMonkeyRequest(token.additionalInfo[1], token.additionalInfo[2]);
            }
            if (animal == AnimalTypes.RABBIT.ordinal()) {
                return new AddRabbitRequest(token.additionalInfo[1], token.additionalInfo[2]);
            }
            if (animal == AnimalTypes.WOLF.ordinal()) {
                return new AddWolfRequest(token.additionalInfo[1]);
            }
            if (animal == AnimalTypes.TIGER.ordinal()) {
                return new AddTigerRequest(token.additionalInfo[1]);
            }
            System.out.println("Неизвестный токен животного.");
            return new StartAgainRequest();
        }
        if (token.value == RequestTypes.QUIT.ordinal()) {
            return new QuitRequest();
        }
        if (token.value == RequestTypes.REPORT.ordinal()) {
            return new ReportRequest();
        }
        if (token.value == RequestTypes.LIST.ordinal()) {
            return new ListRequest();
        }
        if (token.value == RequestTypes.ENUMERATION.ordinal()) {
            return new EnumerationRequest();
        }
        if (token.value == RequestTypes.ADD_ITEM.ordinal()) {
            if (token.additionalInfo[0] == ItemTypes.TABLE.ordinal()) {
                return new AddTableRequest();
            }
            if (token.additionalInfo[0] == ItemTypes.COMPUTER.ordinal()) {
                return new AddComputerRequest();
            }
        }
        System.out.println("Получен неизвестный токен запроса.");
        return new StartAgainRequest();
    }
}
