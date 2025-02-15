package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;

public class EnumerationRequest extends Request {

    @Override
    public int execute(RequestableType smth) {
        String enumeration = smth.storage.contents();
        if (enumeration.isEmpty()) {
            enumeration = "Все хранилища пустые.";
        }
        printer.println(enumeration);
        return 0;
    }
}
