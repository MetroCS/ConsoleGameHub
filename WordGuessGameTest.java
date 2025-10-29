import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for WordGuessGame.
 * @version 1
 */
public class WordGuessGameTest {

    @Test
    public void testCorrectGuessOnFirstTry() {
        String simulatedInput = "APPLE\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        assertEquals(10, result.get());

        System.setIn(originalIn);
    }

    @Test
    public void testIncorrectThenCorrectGuess() {
        String simulatedInput = "MANGO\nAPPLE\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        assertEquals(9, result.get());

        System.setIn(originalIn);
    }

    @Test
    public void testAllIncorrectGuesses() {
        String simulatedInput = "MANGO\nGRAPE\nPLUMB\nBERRY\nPEACH\nLEMON\nCHILI\nGUAVA\nOLIVE\nONION\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        assertEquals(0, result.get());

        System.setIn(originalIn);
    }

    /** correct guess within N tries (within 3: two incorrect then correct) */
    @Test
    public void testCorrectWithinThreeTries() {
        String simulatedInput = "MELON\nGRAPE\nAPPLE\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        // 10 start - 2 valid incorrect = 8 remaining
        assertEquals(8, result.get());

        System.setIn(originalIn);
    }

    /** invalid guess (wrong length or characters) should NOT consume attempts */
    @Test
    public void testInvalidGuessesDoNotConsumeAttempts() {
        // invalid: too short, has digit, has punctuation; then correct
        String simulatedInput = "APP\nAPPL3\nAP-LE\nAPPLE\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        // All invalids ignored; first valid guess is correct -> still 10 remaining
        assertEquals(10, result.get());

        System.setIn(originalIn);
    }

    /** multiple incorrect guesses before a win (4 incorrect then correct) */
    @Test
    public void testMultipleIncorrectBeforeWin() {
        String simulatedInput = "GUAVA\nPEACH\nMELON\nBERRY\nAPPLE\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        // 10 start - 4 valid incorrect = 6 remaining
        assertEquals(6, result.get());

        System.setIn(originalIn);
    }

    /** loss after N incorrect guesses (explicitly verify loss at exactly 10 incorrect) */
    @Test
    public void testLossAfterTenIncorrectGuesses() {
        String simulatedInput =
                "GRAPE\nGRAPE\nGRAPE\nGRAPE\nGRAPE\nGRAPE\nGRAPE\nGRAPE\nGRAPE\nGRAPE\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        assertEquals(0, result.get());

        System.setIn(originalIn);
    }
}
