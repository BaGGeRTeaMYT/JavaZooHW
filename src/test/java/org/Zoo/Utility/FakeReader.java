package org.Zoo.Utility;

import org.Zoo.Console.Readers.ConsoleReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FakeReader implements ConsoleReader {

    public FakeReader() {
        q = new LinkedList<>();
    }

    public void add(String str, String... other) {
        q.add(str);
        if (other.length > 0) {
            add(other[0], Arrays.copyOfRange(other, 1, other.length));
        }
    }

    @Override
    public String getLine() {
        return q.poll();
    }

    @Override
    public int getNum() {
        return 0;
    }

    Queue<String> q;
}