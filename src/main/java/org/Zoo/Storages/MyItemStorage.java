package org.Zoo.Storages;

import org.Zoo.Items.Thing;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class MyItemStorage implements ItemStorage{
    @Override
    public String contents() {
        StringBuilder res = new StringBuilder();
        for (Thing thing : things) {
            String tmpStr = thing.getName() + " с номером " + thing.getNumber() + "\n";
            res.append(tmpStr);
        }

        return res.toString();
    }

    Vector<Thing> things;
}
