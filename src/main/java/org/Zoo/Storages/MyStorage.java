package org.Zoo.Storages;

import org.springframework.stereotype.Component;

@Component
public class MyStorage extends Storage {
    MyStorage(AnimalStorage animalStorage, ItemStorage itemStorage) {
        this.animalStorage = animalStorage;
        this.itemStorage = itemStorage;
    }
}
