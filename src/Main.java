import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Main {



    static String[] textFileToStringArray(String string){
        return string.split("\\s+");
    }

    static boolean checkForCorrectWord(String guess, String word) {
        word = word.toLowerCase()
                .replaceAll("[^\\p{IsAlphabetic}\\s]", "")
                .replaceAll("\\s+", " ")
                .trim();
        guess = guess.toLowerCase()
                .replaceAll("[^\\p{IsAlphabetic}\\s]", "")
                .replaceAll("\\s+", " ")
                .trim();
        return guess.equals(word);
    }

    static void readArray(String[] array, int beggining, int end ){
        end = Math.min(end, array.length);
        for (int i = beggining; i < end;  i++){
            System.out.print(array[i] + " ");
            if (i % 10 == 9){System.out.println("\n");}
        }
    }



    public static void main(String[] args) {
        String text = "";
        try {text = Files.readString(Path.of("docs","sonnet.txt"));
        }
        catch (IOException e) {
            System.err.println("Could not read file: " + e.getMessage());
        }

        String[] sonnet = textFileToStringArray(text);

        int length = sonnet.length;
        int correct = 0;
        int wrong = 0;
        int wordToBeGuessed = 0;
        boolean wordFound;
        Scanner scanner = new Scanner(System.in);


        while (correct < 3 && wrong < 3) {
            // choose random number between word last guessed and end
            int lastWord = wordToBeGuessed;
            wordToBeGuessed = (int) (Math.random()*(length - wordToBeGuessed - 5 + correct + wrong) + wordToBeGuessed + 1);

            readArray(sonnet, lastWord, wordToBeGuessed);
            System.out.println("\n Enter word: ");
            // for testing: System.out.println(sonnet[wordToBeGuessed]);
            wordFound = checkForCorrectWord(scanner.next(), sonnet[wordToBeGuessed]);

            if (wordFound) {
                correct++;
                System.out.println("Correct! \n");
            }

            else {
                wrong++;
                System.out.print("Incorrect! \n");
            }
        }

        if (correct == 3) {
            System.out.println("You succeeded!");
        }
        else System.out.println("You failed!");

        /*
        Logic
        write a program that writes out the sonnet and stops at a random word,
        printing a series of underscores instead, and not printing the rest of the sonnet.
        The program should prompt the user for the next word. Once the user responds,
        the program should indicate correct or error, and restart the sonnet, stopping at a
        different word. Program continues until the user gets three words correct or three words
        incorrect.

        */
    }
}
