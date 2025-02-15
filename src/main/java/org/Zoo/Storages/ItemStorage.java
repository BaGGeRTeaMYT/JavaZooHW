package org.Zoo.Storages;

import org.Zoo.Items.Thing;

public interface ItemStorage {
    String contents();
    void add(Thing thing);
    String version();
    String describe(Thing thing);
}
