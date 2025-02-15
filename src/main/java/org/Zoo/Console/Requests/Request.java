package org.Zoo.Console.Requests;

import org.Zoo.Console.Printers.MyPrinter;
import org.Zoo.Console.Printers.Printer;

public abstract class Request implements RequestInterface {
    public Request(int value, int additionalInfo) {
        this.value = value;
        this.additionalInfo = additionalInfo;
        this.printer = new MyPrinter();
    }

    public Request(int value) {
        this.value = value;
        this.additionalInfo = 0;
        this.printer = new MyPrinter();
    }

    public Request() {
        this.printer = new MyPrinter();
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public int value;
    public int additionalInfo;
    protected Printer printer;
}
