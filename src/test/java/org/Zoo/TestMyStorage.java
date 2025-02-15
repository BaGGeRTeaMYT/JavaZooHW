package org.Zoo;

import org.Zoo.Animals.Rabbit;
import org.Zoo.Animals.Wolf;
import org.Zoo.Items.Computer;
import org.Zoo.Storages.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMyStorage {
    @Autowired
    private Storage storage;

    @Test
    void testStorage() {
        Wolf first = new Wolf(3);
        storage.add(first);
        Computer second = new Computer();
        storage.add(second);
        Rabbit third = new Rabbit(3, 7);
        storage.add(third);
        Assertions.assertEquals(0, first.getNumber());
        Assertions.assertEquals(1, second.getNumber());
        Assertions.assertEquals(2, third.getNumber());
        Rabbit angryRabbit = new Rabbit(3, 0);
        storage.add(angryRabbit);
        String report = storage.report();
        String kindList = storage.kindHerbivores();
        String contents = storage.contents();
        String expectedReport = "Животных в зоопарке: 3\n" +
                "Необходимо корма в день: 9.";
        String expectedKindList = "\tЖивотное Заяц\n" +
                "\t\tНомер: 2\n" +
                "\t\tТребует еды: 3\n" +
                "\t\tДоброта: 7";
        String expectedContents = "Животные:\n" +
                "\tЖивотное Волк\n" +
                "\t\tНомер: 0\n" +
                "\t\tТребует еды: 3\n" +
                "\tЖивотное Заяц\n" +
                "\t\tНомер: 2\n" +
                "\t\tТребует еды: 3\n" +
                "\t\tДоброта: 7\n" +
                "\tЖивотное Заяц\n" +
                "\t\tНомер: 3\n" +
                "\t\tТребует еды: 3\n" +
                "\t\tДоброта: 0\n" +
                "Предметы:\n" +
                "\tПредмет Компьютер\n" +
                "\t\tНомер: 1";
        Assertions.assertEquals(expectedReport, report);
        Assertions.assertEquals(expectedKindList, kindList);
        Assertions.assertEquals(expectedContents, contents);
    }

}
