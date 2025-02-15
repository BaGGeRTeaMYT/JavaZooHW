package org.Zoo.Console.Commands;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

public class CommandToken {
    public CommandToken(int tokenType, int value, int[] additionalInfo) {
        this.tokenType = tokenType;
        this.value = value;
        this.additionalInfo = additionalInfo;
    }
    public CommandToken(int tokenType, int value) {
        this.tokenType = tokenType;
        this.value = value;
    }
    public CommandToken(int tokenType) {
        this.tokenType = tokenType;
        value = 0;
    }

    void setValue(int newValue) {
        value = newValue;
    }

    public int tokenType;
    public int value;
    public int[] additionalInfo;
}
