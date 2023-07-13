package org.example;

import org.junit.jupiter.api.Test;

public class ExampleTest {
    private static SimpleMathLibrary mathLibrary = new SimpleMathLibrary();

    @Test
    public void testAdd() {
        double result = mathLibrary.add(2.5, 3.5);
        if (result == 6.0) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    @Test
    public void testMinus() {
        double result = mathLibrary.minus(5.0, 2.0);
        if (result == 3.0) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }
}