import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Приклад виклику методів
        List<String> stringList = new ArrayList<>(Arrays.asList("bird", "fox", "cat", "bird", "dog", "cat"));
        System.out.println(countOccurance(stringList, "bird")); // повинно вивести 2
        int[] intArray = new int[]{1, 2, 3};
        List<Integer> intList = toList(intArray);
        System.out.println(intList); // повинно вивести [1, 2, 3]
        List<Integer> intList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1, 4));
        System.out.println(findUnique(intList2)); // повинно вивести [1, 2, 3, 4]
        calcOccurance(stringList); // повинно вивести кількість повторень кожного слова
        System.out.println(findOccurance(stringList)); // повинно вивести список структур зі словами
    }
    public static int countOccurance(List<String> words, String word) {
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }
    public static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }
    public static List<Integer> findUnique(List<Integer> nums) {
        List<Integer> uniqueNums = new ArrayList<Integer>();
        for (int num : nums) {
            if (!uniqueNums.contains(num)) {
                uniqueNums.add(num);
            }
        }
        return uniqueNums;
    }
    public static void calcOccurance(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        for (String word : wordCount.keySet()) {
            System.out.println(word + ": " + wordCount.get(word));
        }
    }
    public static List<Map<String, Object>> findOccurance(List<String> words) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        for (String word : wordCount.keySet()) {
            Map<String, Object> wordOccurrence = new HashMap<String, Object>();
            wordOccurrence.put("name", word);
            wordOccurrence.put("occurrence", wordCount.get(word));
            result.add(wordOccurrence);
        }
        return result;
    }
}