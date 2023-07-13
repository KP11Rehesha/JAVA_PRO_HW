package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayManipulationTest {
    @Test
    public void testExtractElementsAfterLastFour() {
        int[] input1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expected1 = {1, 7};
        assertArrayEquals(expected1, ArrayManipulation.extractElementsAfterLastFour(input1));

        int[] input2 = {4, 4, 4, 4};
        int[] expected2 = {};
        assertArrayEquals(expected2, ArrayManipulation.extractElementsAfterLastFour(input2));

        int[] input3 = {1, 2, 3};
        RuntimeException exception3 = assertThrows(RuntimeException.class,
                () -> ArrayManipulation.extractElementsAfterLastFour(input3));
        assertEquals("Input array does not contain a four.", exception3.getMessage());

        int[] input4 = {};
        RuntimeException exception4 = assertThrows(RuntimeException.class,
                () -> ArrayManipulation.extractElementsAfterLastFour(input4));
        assertEquals("Input array is empty or null.", exception4.getMessage());
    }

    @Test
    public void testContainsOnlyOnesAndFours() {
        int[] input1 = {1, 1, 1, 4, 4, 1, 4, 4};
        assertTrue(ArrayManipulation.containsOnlyOnesAndFours(input1));

        int[] input2 = {1, 1, 1, 1, 1, 1};
        assertFalse(ArrayManipulation.containsOnlyOnesAndFours(input2));

        int[] input3 = {4, 4, 4, 4};
        assertFalse(ArrayManipulation.containsOnlyOnesAndFours(input3));

        int[] input4 = {1, 4, 4, 1, 1, 4, 3};
        assertFalse(ArrayManipulation.containsOnlyOnesAndFours(input4));
    }
}