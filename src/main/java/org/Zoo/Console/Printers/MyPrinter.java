package org.Zoo.Console.Printers;

public class MyPrinter implements Printer {
    @Override
    public void print(String out) {
        System.out.print(out);
    }

    @Override
    public void println(String out) {
        System.out.println(out);
    }
}
