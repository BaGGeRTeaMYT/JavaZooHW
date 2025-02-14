package org.Zoo.Console.Requests;

import org.Zoo.Storages.Storage;
import org.Zoo.Vet.VetClinic;

public class RequestableType {
    VetClinic vet;
    Storage storage;

    public RequestableType(VetClinic vet, Storage storage) {
        this.vet = vet;
        this.storage = storage;
    }

}
