package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
public class AnimalTest {
    @Test
    public void getFoodErrorMessage() {
        Animal animal = new Animal();
        String errorMesasge = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Собака"));
        assertEquals(errorMesasge, exception.getMessage());
    }
    @Test
    public void getFamily() {
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }

}
