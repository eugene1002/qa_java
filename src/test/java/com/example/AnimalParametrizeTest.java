package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParametrizeTest {
    private final String animalKind;
    private final List<String> expected;

    public AnimalParametrizeTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters(name ="Список еды.тестовые данные:{0},{1}")
    public static Object[][] getFoodData() {
        return new Object[][]{{"Травоядное", List.of("Трава", "Различные растения")}, {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }
    @Test
    public void getFood() throws Exception {
        Animal animal = new Animal();
        List<String> stringList = animal.getFood(animalKind);
        assertEquals(expected, stringList);
    }
}
