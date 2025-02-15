package org.Zoo;

import org.Zoo.Console.MyConsole;
import org.Zoo.Utility.FakePrinter;
import org.Zoo.Utility.FakeReader;
import org.Zoo.Utility.FakeRequestGen;
import org.Zoo.Utility.TestingProcessor;
import org.Zoo.Storages.MyAnimalStorage;
import org.Zoo.Storages.MyItemStorage;
import org.Zoo.Storages.MyStorage;
import org.Zoo.Vet.RandomVet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestZooCoordinator {

    @Test
    void testZoo() {
        FakeReader reader = new FakeReader();
        FakePrinter actualOutput = new FakePrinter();
        FakeRequestGen gen = new FakeRequestGen(actualOutput);
        ZooCoordinator zoo = new ZooCoordinator(new MyConsole(new TestingProcessor(reader, gen)), new MyStorage(new MyAnimalStorage(), new MyItemStorage()), new RandomVet());
        reader.add("add_item", "computer", "add_animal", "rabbit", "3", "2", "add_animal", "monkey", "6", "8", "add_item", "table", "report", "all", "list", "quit");
        zoo.coordinate();

        StringBuilder expectedAll = new StringBuilder();

        String test;
        test = actualOutput.lastOutput();
        int animalCounter = 0;
        int requiredFood = 0;
        String expectedList = "";
        if (test.equals("Заяц добавлен в зоопарк.")) {
            animalCounter++;
            requiredFood += 3;
            String rabbitDescription =
                    """
                            Животные:
                            \tЖивотное Заяц
                            \t\tНомер: 1
                            \t\tТребует еды: 3
                            \t\tДоброта: 2""";
            expectedAll.append(rabbitDescription);
        } else if (!test.equals("Заяц не прошёл проверку здоровья.")) {
            Assertions.fail();
        }
        test = actualOutput.lastOutput();
        if (test.equals("Обезьяна добавлена в зоопарк.")) {
            animalCounter++;
            requiredFood += 6;
            String monkeyDescription =
                    """
                            \tЖивотное Обезьяна
                            \t\tНомер: 2
                            \t\tТребует еды: 6
                            \t\tДоброта: 8""";
            if (expectedAll.isEmpty()) {
                expectedAll.append("Животные:\n");
            } else {
                expectedAll.append("\n");
            }
            expectedAll.append(monkeyDescription);

            expectedList = """
                    \tЖивотное Обезьяна
                    \t\tНомер: 2
                    \t\tТребует еды: 6
                    \t\tДоброта: 8""";
        } else if (!test.equals("Обезьяна не прошла проверку здоровья.")) {
            Assertions.fail();
        }

        expectedAll.append("""
                
                Предметы:
                \tПредмет Компьютер
                \t\tНомер: 0;
                \tПредмет Стол
                \t\tНомер: 3""");

        String expectedReport =
                "Животных в зоопарке: " + animalCounter + "\n" +
                "Необходимо корма в день: " + requiredFood + ".";
        Assertions.assertEquals(expectedReport, actualOutput.lastOutput());
        Assertions.assertEquals(expectedAll.toString(), actualOutput.lastOutput());
        Assertions.assertEquals(expectedList, actualOutput.lastOutput());
    }
}
