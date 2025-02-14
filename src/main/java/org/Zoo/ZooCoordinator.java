package org.Zoo;

import org.Zoo.Console.ConsoleInterface;
import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestableType;
import org.Zoo.Storages.Storage;
import org.Zoo.Vet.VetClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZooCoordinator {

    private final ConsoleInterface console;
    private final Storage storage;
    private final VetClinic vet;

    @Autowired
    ZooCoordinator(ConsoleInterface console, Storage storage, VetClinic vet) {
        this.console = console;
        this.storage = storage;
        this.vet = vet;
        coordinate();
    }

    void coordinate() {
        int requestResult = 0;
        RequestableType type = new RequestableType(vet, storage);
        while (requestResult >= 0) {
            Request request = console.readInput();
            requestResult = request.execute(type);
        }
    }
}
