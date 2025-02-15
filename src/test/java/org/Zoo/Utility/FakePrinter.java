package org.Zoo.Utility;

import org.Zoo.Console.Printers.Printer;

import java.util.LinkedList;
import java.util.Queue;

public class FakePrinter implements Printer {

    public FakePrinter() {
        q = new LinkedList<>();
    }

    @Override
    public void print(String out) {
        q.add(out);
    }

    @Override
    public void println(String out) {
        q.add(out);
    }

    public String lastOutput() {
        return q.poll();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    Queue<String> q;
}
