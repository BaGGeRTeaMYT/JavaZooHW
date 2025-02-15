package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;

public class ListRequest extends Request {
    @Override
    public int execute(RequestableType smth) {
        System.out.println(smth.storage.kindHerbivores());
        return 0;
    }
}
