package org.Zoo;

import org.Zoo.Console.ConsoleInterface;
import org.Zoo.Console.Processor;
import org.Zoo.Console.Requests.ConcreteRequests.*;
import org.Zoo.Console.Requests.Request;
import org.Zoo.Console.Requests.RequestGenerator.MyRequestGen;
import org.Zoo.Utility.FakeReader;
import org.Zoo.Utility.StupidProcessor1;
import org.Zoo.Utility.StupidProcessor2;
import org.Zoo.Utility.TestingProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMyConsole {
    @Autowired
    private ConsoleInterface console;


    @Test
    @DisplayName("Test setProcessor")
    void testConsole() {
//        Always creates QuitRequest
        StupidProcessor1 proc1 = new StupidProcessor1();

//        Always creates ReportRequest
        StupidProcessor2 proc2 = new StupidProcessor2();
        console.setProcessor(proc1);
        Assertions.assertInstanceOf(QuitRequest.class, console.readInput());
        console.setProcessor(proc2);
        Assertions.assertInstanceOf(ReportRequest.class, console.readInput());
    }




    @Test
    @DisplayName("Test MyProcessor functioning")
    void testProcessor() {

        FakeReader reader = new FakeReader();

        Processor processor = new TestingProcessor(reader, new MyRequestGen());
        console.setProcessor(processor);

        Request request;

        String[] addAnimal = {"add_animal", "AdD_ANimaL", "ADD_ANIMAL"};

        String[] tigerNames = {"tiger", "TiGeR", "ТиГР", "тигр"};
        for (String name : tigerNames) {
            for (String cmd : addAnimal) {
                reader.add(cmd, name, "5");
                request = console.readInput();
                Assertions.assertInstanceOf(AddTigerRequest.class, request);
                Assertions.assertEquals(5, request.value);
            }
        }

        String[] monkeyNames = {"monkey", "MoNkEY", "ОбЕЗЬяна", "обезьяна"};
        for (String name : monkeyNames) {
            for (String cmd : addAnimal) {
                reader.add(cmd, name, "3", "8");
                request = console.readInput();
                Assertions.assertInstanceOf(AddMonkeyRequest.class, request);
                Assertions.assertEquals(3, request.value);
                Assertions.assertEquals(8, request.additionalInfo);
            }
        }

        String[] rabbitNames = {"rabbit", "RaBBIt", "ЗаЯц", "заяц"};
        for (String name : rabbitNames) {
            for (String cmd : addAnimal) {
                reader.add(cmd, name, "1", "6");
                request = console.readInput();
                Assertions.assertInstanceOf(AddRabbitRequest.class, request);
                Assertions.assertEquals(1, request.value);
                Assertions.assertEquals(6, request.additionalInfo);
            }
        }

        String[] wolfNames = {"wolf", "WolF", "ВОлК", "волк"};
        for (String name : wolfNames) {
            for (String cmd : addAnimal) {
                reader.add(cmd, name, "4");
                request = console.readInput();
                Assertions.assertInstanceOf(AddWolfRequest.class, request);
                Assertions.assertEquals(4, request.value);
            }
        }

        String[] addItem = {"add_item", "Add_ItEM", "ADD_ITEM"};
        String[] computerNames = {"computer", "ComPUtER", "комПЬЮтер", "компьютер"};
        for (String name : computerNames) {
            for (String cmd : addItem) {
                reader.add(cmd, name);
                Assertions.assertInstanceOf(AddComputerRequest.class, console.readInput());
            }
        }

        String[] tableNames = {"table", "tAbLe", "СтОЛ", "стол"};
        for (String name : tableNames) {
            for (String cmd : addItem) {
                reader.add(cmd, name);
                Assertions.assertInstanceOf(AddTableRequest.class, console.readInput());
            }
        }

        reader.add("all");
        Assertions.assertInstanceOf(EnumerationRequest.class, console.readInput());

        reader.add("list");
        Assertions.assertInstanceOf(ListRequest.class, console.readInput());

        reader.add("report");
        Assertions.assertInstanceOf(ReportRequest.class, console.readInput());

        reader.add("quit");
        Assertions.assertInstanceOf(QuitRequest.class, console.readInput());

        reader.add("add_animal", "abort", "quit");
        Assertions.assertInstanceOf(QuitRequest.class, console.readInput());

        reader.add("add_animal", "rabbit", "3", "abort", "quit");
        Assertions.assertInstanceOf(QuitRequest.class, console.readInput());
        reader.add("h","h", "h", "h", "add_animal", "rabbit", "3", "abort", "quit");
        Assertions.assertInstanceOf(QuitRequest.class, console.readInput());
    }
}
