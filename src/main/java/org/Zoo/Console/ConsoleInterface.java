package org.Zoo.Console;

import org.Zoo.Console.Requests.Request;

public interface ConsoleInterface {

    void setProcessor(Processor processor);
    Request readInput();
}
