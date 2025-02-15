package org.Zoo.Console.Commands.ConcreteCommands;

import org.Zoo.Console.Printers.MyPrinter;
import org.Zoo.Console.Printers.Printer;
import org.Zoo.Console.Readers.ConsoleReader;
import org.Zoo.Console.Readers.MyReader;

public abstract class NTCommandPrototype implements NonTerminalCommand {

    NTCommandPrototype() {
        this.reader = new MyReader();
        this.printer = new MyPrinter();
    }

    public void setReader(ConsoleReader reader) {
        this.reader = reader;
        this.printer = new MyPrinter();
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    ConsoleReader reader;
    Printer printer;
}
