package org.Zoo.Console.Commands;

public class CommandToken {
    CommandToken(int tokenType_, int value_) {
        tokenType = tokenType_;
        value = value_;
    }
    CommandToken(int tokenType_) {
        tokenType = tokenType_;
        value = 0;
    }

    void setValue(int newValue) {
        value = newValue;
    }

    public int tokenType;
    public int value;
    public int additionalInfo;
}
