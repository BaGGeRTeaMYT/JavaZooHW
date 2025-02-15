package org.Zoo.Storages;

import org.Zoo.Items.Thing;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class MyItemStorage implements ItemStorage{

    public MyItemStorage() {
        this.things = new Vector<Thing>();
    }

    @Override
    public String contents() {
        StringBuilder res = new StringBuilder();
        boolean firstElement = true;
        for (Thing thing : things) {
            if (firstElement) {
                res.append("Предметы:\n");
                firstElement = false;
            } else {
                res.append(";\n");
            }

            String tmpStr = describe(thing);
            res.append(tmpStr);
        }

        return res.toString();
    }

    @Override
    public void add(Thing thing) {
        things.add(thing);
    }

    @Override
    public String version() {
        return "1.0.0";
    }

    @Override
    public String describe(Thing thing) {
        return "\tПредмет " + thing.getName() + "\n" +
               "\t\tНомер: " + thing.getNumber();
    }

    Vector<Thing> things;
}
