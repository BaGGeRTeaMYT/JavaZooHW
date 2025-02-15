package org.Zoo.Console.Readers;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyReader implements ConsoleReader {
    @Override
    public String getLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public int getNum() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
