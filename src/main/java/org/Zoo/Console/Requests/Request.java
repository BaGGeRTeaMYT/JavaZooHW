package org.Zoo.Console.Requests;

import org.Zoo.ZooCoordinator;

public abstract class Request implements RequestInterface {
    public Request(int value, int additionalInfo) {
        this.value = value;
        this.additionalInfo = additionalInfo;
    }

    public Request(int value) {
        this.value = value;
        this.additionalInfo = 0;
    }

    public int value;
    public int additionalInfo;
}
