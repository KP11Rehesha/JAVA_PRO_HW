public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println("________________________________________");

        checkSumSign();
        System.out.println("________________________________________");

        printColor();
        System.out.println("________________________________________");

        compareNumbers();
        System.out.println("________________________________________");

        System.out.println(checkSumBetween10_20(5, 20));
        System.out.println("________________________________________");

        checkPositiveNegative(-1);
        System.out.println("________________________________________");

        System.out.println(checkBoolPositiveNegative(10));
        System.out.println("________________________________________");

        printNString("Домашнє завдання виконано", 7);
        System.out.println("________________________________________");

        System.out.println(checkLeapYear(1500));
        System.out.println("________________________________________");
    }

    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    private static void checkSumSign() {
        int a = 0;
        int b = -20;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сума позитивна");
        } else {
            System.out.println("Сума негативна");
        }
    }

    private static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    private static void compareNumbers() {
        int a = 0;
        int b = 20;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }

    }

    private static boolean checkSumBetween10_20(int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static void checkPositiveNegative(int a) {
        if (a >= 0) {
            System.out.println("Позитивне");
        } else {
            System.out.println("Негативне");
        }
    }

    private static boolean checkBoolPositiveNegative(int a) {
        if (a >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void printNString(String string, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ") " + string);
        }
    }

    private static boolean checkLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
