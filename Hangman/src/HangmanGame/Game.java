package HangmanGame;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String word = "experiment";
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);
        int attempts = word.length() + 3;
        boolean isWon = false;

        while (attempts > 0 && !isWon) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean found = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                attempts--;
            }

            isWon = true;
            for (char c : guessedWord) {
                if (c == '_') {
                    isWon = false;
                    break;
                }
            }

            System.out.println(guessedWord);
        }

        if (isWon) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost. The word was: " + word);
        }

        scanner.close();
    }
}

