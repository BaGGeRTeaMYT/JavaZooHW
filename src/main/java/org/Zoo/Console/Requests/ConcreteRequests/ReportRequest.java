package org.Zoo.Console.Requests.ConcreteRequests;

import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;

public class ReportRequest extends Request {

    @Override
    public int execute(RequestableType smth) {
        System.out.println(smth.storage.report());
        return 0;
    }
}
