package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulation {
    public static int[] extractElementsAfterLastFour(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Input array is empty or null.");
        }

        List<Integer> extractedElements = new ArrayList<>();
        boolean foundLastFour = false;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                foundLastFour = true;
                break;
            }
            extractedElements.add(array[i]);
        }

        if (!foundLastFour) {
            throw new RuntimeException("Input array does not contain a four.");
        }

        int[] result = new int[extractedElements.size()];
        for (int i = 0; i < extractedElements.size(); i++) {
            result[i] = extractedElements.get(extractedElements.size() - 1 - i);
        }

        return result;
    }

    public static boolean containsOnlyOnesAndFours(int[] array) {
        boolean containsOne = false;
        boolean containsFour = false;

        for (int num : array) {
            if (num == 1) {
                containsOne = true;
            } else if (num == 4) {
                containsFour = true;
            }
        }

        return containsOne && containsFour;
    }
}