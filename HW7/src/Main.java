import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String str = "Hello World";
        char ch = 'l';
        int count = findSymbolOccurance(str, ch);

        String original = "Hello";
        String reversed = stringReverse(original);

        String source = "Apollo";
        String target = "pollo";
        int position = findWordPosition(source, target);

        String palindrome = "level";
        boolean isPal = isPalindrome(palindrome);

        System.out.println("Виклик методу findSymbolOccurance\n"

                +"Кількість входжень символу " + ch + " у рядок " + str + ": " + count

                +"\n____________________________________________\n"

                + "Виклик методу findWordPosition\n"

                + "Наявність " + target + " у рядку " + source + ": " + position

                +"\n____________________________________________\n"

                + "Виклик методу stringReverse\n"

                + "Реверсований рядок " + original + ": " + reversed

                +"\n____________________________________________\n"

                + "Виклик методу isPalindrome\n"

                + "Рядок " + palindrome + " є паліндромом? " + isPal);

    }

    public static int findSymbolOccurance(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        int position = source.indexOf(target);
        return position;
    }

    public static String stringReverse(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }

    public static boolean isPalindrome(String str) {
        String reverse = stringReverse(str);
        if (str.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }
}