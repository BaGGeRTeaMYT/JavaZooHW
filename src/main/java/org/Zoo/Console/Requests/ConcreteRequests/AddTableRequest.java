package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;
import org.Zoo.Items.Table;

public class AddTableRequest extends Request {

    @Override
    public int execute(RequestableType smth) {
        smth.storage.add(new Table());
        return 0;
    }
}
