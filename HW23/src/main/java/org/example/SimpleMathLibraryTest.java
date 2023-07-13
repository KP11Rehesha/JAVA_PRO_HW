package org.example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleMathLibraryTest {
    private final SimpleMathLibrary mathLibrary = new SimpleMathLibrary();

    @Test
    public void testAdd() {
        double result = mathLibrary.add(2.5, 3.5);
        assertEquals(6.0, result, 0.01);
    }

    @Test
    public void testMinus() {
        double result = mathLibrary.minus(5.0, 2.0);
        assertEquals(3.0, result, 0.01);
    }
}

