package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;
import org.Zoo.Items.Computer;

public class AddComputerRequest extends Request {

    @Override
    public int execute(RequestableType smth) {
        smth.storage.add(new Computer());
        return 0;
    }
}
