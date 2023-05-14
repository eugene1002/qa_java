package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(Parameterized.class)
public class LionParametrizeTest {
    private final String sex;
    private final boolean expected;

    @Mock
    Feline feline;

    public LionParametrizeTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Пол Льва.Тестовые данные:{0},{1}")
    public static Object[][] getLionData() {
        return new Object[][]{{"Самец", true},
                {"Самка", false}};
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, sex);
        assertEquals(1, lion.getKittens());

    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(feline, sex);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testExceptionMessage() throws Exception {
        String exceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "неизвестен"));
        assertEquals(exceptionMessage, exception.getMessage());
    }
}
