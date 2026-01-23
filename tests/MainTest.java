import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {

    @Test
    void checkForCorrectWordWeirdCase() {
        String  guess1 = ", + heLLo,+ ";
        String  guess2 = "Hello";

        boolean correct = Main.checkForCorrectWord(guess1, guess2);
        assertTrue(correct);
    }

    @Test
    void readArray() {
        String[] arrayTest = {"Hello", "I've", "come", "to", "test", "this", "!"};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        Main.readArray(arrayTest, 2, 4);

        // Assert
        assertEquals("come to ", outContent.toString());
    }

    @Test
    void printUnderlines() {
        int length = 6;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.printUnderlines(length);

        assertEquals("______", outContent.toString());
    }

    @Test
    void main() {
      /*difficult to test, will only test functions of main
      and leave main here for future testing if applicable
       */
    }
}