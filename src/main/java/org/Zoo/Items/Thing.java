package org.Zoo.Items;

import org.Zoo.RequiredInterfaces.IInventory;

public class Thing implements IInventory {

    public String getName() {
       return "Предмет";
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    int number;
}
