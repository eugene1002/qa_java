package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {
    private int expectedResultKittensCount=5;

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(expectedResultKittensCount, feline.getKittens(5));
    }

}
