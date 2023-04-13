import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "f"}
        };

        try {
            int sum = doCalc(arr);
            System.out.println("The sum is: " + sum);
        } catch (ArraySizeException | ArrayDataException e) {
            e.printStackTrace();
        }
    }
    public static int doCalc(String[][] arr) throws ArraySizeException, ArrayDataException {
        if (arr.length != 4 || Arrays.stream(arr).anyMatch(row -> row.length != 4)) {
            throw new ArraySizeException("The array size should be 4x4");
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in cell (" + i + "," + j + "): " + arr[i][j], e);
                }
            }
        }

        return sum;
    }
}