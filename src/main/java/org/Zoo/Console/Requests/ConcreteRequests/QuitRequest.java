package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;

public class QuitRequest extends Request {
    @Override
    public int execute(RequestableType smth) {
        return -1;
    }
}
