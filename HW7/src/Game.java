import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon"};

        Random random = new Random();
        int index = random.nextInt(words.length);
        String wordToGuess = words[index];
        int wordLength = wordToGuess.length();

        Scanner scanner = new Scanner(System.in);

        String guessedWord = "";
        while (!guessedWord.equals(wordToGuess)) {
            System.out.print("Guess the word: ");
            guessedWord = scanner.next().toLowerCase();

            if (guessedWord.equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word!");
            } else {
                for (int i = 0; i < wordLength; i++) {
                    if (i >= guessedWord.length()) {
                        System.out.print("#");
                    } else if (wordToGuess.charAt(i) == guessedWord.charAt(i)) {
                        System.out.print(wordToGuess.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }
    }
}
