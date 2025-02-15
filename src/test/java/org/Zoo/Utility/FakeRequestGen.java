package org.Zoo.Utility;

import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Printers.Printer;
import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestGenerator.MyRequestGen;

public class FakeRequestGen extends MyRequestGen {

    public FakeRequestGen() {
        this.printer = new FakePrinter();
    }

    public FakeRequestGen(Printer printer) {
        this.printer = printer;
    }

    @Override
    public Request generate(CommandToken token) {
        Request request = super.generate(token);
        request.setPrinter(printer);
        return request;
    }

    Printer printer;
}
