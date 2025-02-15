package org.Zoo;

import org.Zoo.Animals.Rabbit;
import org.Zoo.Vet.RandomVet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRandomVet {
    @Autowired
    private RandomVet vet;

    @Test
    void vetTest() {
        Rabbit rabbit = new Rabbit(3, 2);
        int successCount = 0;
        for (int i = 0; i < (int)1e+6; i++) {
            successCount += (vet.checkHealth(rabbit) ? 1 : 0);
        }
        double acceptRatio = successCount/(1e+6);
        Assertions.assertTrue( (0.94 < acceptRatio && acceptRatio < 0.96) );
    }
}
