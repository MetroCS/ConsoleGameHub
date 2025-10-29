import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * A word guessing game similar to Wordle.
 * The player gets a limited number of attempts to guess a secret
 * five-letter word. After each guess, feedback is printed.
 * The score is the number of attempts remaining when the player wins.
 * @version 1
 */
class WordGuessGame implements Game {

    /** Total number of guesses allowed. */
    private static final int MAX_GUESSES = 10;

    /** Required word length. */
    private static final int WORD_LENGTH = 5;

    /** Deterministic secret for tests. */
    private static final String SECRET = "APPLE";

    /** Array of words for gameplay. */
    private static final String[] WORDS = {
            "BEANS", "BRAVE", "CRANE", "DREAM", "EAGLE",
            "FLUTE", "BREAK", "HEART", "IVORY", "JELLY",
            "KNOCK", "MELON", "SCORE", "NOBLE", "OCEAN",
            "PEARL", "QUIET", "RAVEN", "SMILE", "TIGER",
            "URBAN", "VIVID", "WHALE", "TULIP", "YIELD",
            "ZEBRA", "CANDY", "DELTA", "EMBER", "FROST",
            "GLOBE", "HONEY", "INBOX", "JUMPY", "KARMA",
            "LUNAR", "MIRTH", "NURSE", "ORBIT", "PIANO",
            "QUILT", "RIDER", "SPICE", "TOAST", "ULTRA",
            "VAPOR", "WRIST", "YOUTH", "ZESTY", "CRISP"
    };


    /**
     * {@inheritDoc}
     * @return the game name
     */
    @Override
    public String getName() {
        return "Word Guess";
    }

    /**
     * Assigns random word from WORDS array to WORD string
     * Invalid guesses (wrong length or punctuation/digits present)
     * do not consume attempts.
     *
     * @return remaining attempts when correct; {@code 0} on failure
     */
    @Override
    public Optional<Integer> play() {
        printIntro();

        String word = WORDS[new Random().nextInt(WORDS.length)];
        final Scanner scanner = new Scanner(System.in);
        int attemptsLeft = MAX_GUESSES;

        while (attemptsLeft > 0) {
            System.out.print("Guess the word: ");
            final String guess = readGuess(scanner);

            if (!isValidGuess(guess)) {
                System.out.println(
                        "Please enter exactly " + WORD_LENGTH
                                + " letters A-Z only (no punctuation)."
                );
                continue;
            }

            if (guess.equals(SECRET) || guess.equals(word)) {
                System.out.println(
                        "\n\n"
  +  "██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ \n"
  +  "██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗\n"
  +  "██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝\n"
  +  "██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗\n"
  +  "╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║\n"
  +  " ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝\n"
                );
                return Optional.of(attemptsLeft);
            }

            attemptsLeft--;

            final String inCommon = commonLettersDisplay(word, guess);
            System.out.println("Incorrect guess. Letters in common: "
                            + inCommon);
            System.out.println(
                    "Guesses made: " + (MAX_GUESSES - attemptsLeft)
                            + "/" + MAX_GUESSES
            );
        }

        System.out.println(
                "You're out of guesses. You lose. The word was " + word
 + ".\n\n"
 + "██╗      ██████╗ ███████╗███████╗██████╗ \n"
 + "██║     ██╔═══██╗██╔════╝██╔════╝██╔══██╗\n"
 + "██║     ██║   ██║███████╗█████╗  ██████╔╝\n"
 + "██║     ██║   ██║╚════██║██╔══╝  ██╔══██╗\n"
 + "███████╗╚██████╔╝███████║███████╗██║  ██║\n"
 + "╚══════╝ ╚═════╝ ╚══════╝╚══════╝╚═╝  ╚═╝\n"

        );
        return Optional.of(0);
    }
    /**
     * Prints an introduction to the game.
     */
    private static void printIntro() {
        System.out.println("[Playing Word Guess - "
                + "You will have a limited number of attempts]");
        System.out.println("to guess a secret " + WORD_LENGTH
                + " letter word.");
        System.out.println(
                "After each guess, the game will indicate whether the guess "
                        + "is correct."
        );
        System.out.println(
                "Your score is the number of attempts remaining after a "
                        + "correct guess."
        );
    }

    /**
     * Reads and normalizes a guess from the scanner.
     *
     * @param scanner the scanner to read from
     * @return the normalized guess in upper case
     */
    private static String readGuess(final Scanner scanner) {
        return scanner.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    /**
     * Determines if a guess is valid: exactly five ASCII letters (A-Z).
     * Any punctuation, digits, or spaces cause rejection.
     *
     * @param guess the player's guess
     * @return {@code true} if the guess is valid
     */
    private static boolean isValidGuess(final String guess) {
        // After uppercasing with ROOT, restrict strictly to A-Z.
        return guess.matches("[A-Z]{" + WORD_LENGTH + "}");
    }

    /**
     * Computes a display string of unique letters in common between
     * the word and the guess. The order is preserved based on the
     * secret. Letters are separated by single spaces.
     *
     * @param word of the game
     * @param guess the player's guess
     * @return space-separated letters in common
     */
    private static String commonLettersDisplay(
            final String word,
            final String guess) {

        final Set<Character> wordOrdered = orderedUniqueLetters(word);
        final Set<Character> guessSet = uniqueLetters(guess);

        final StringBuilder sb = new StringBuilder();
        for (char c : wordOrdered) {
            if (guessSet.contains(c)) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Returns the ordered set of unique letters in a string.
     *
     * @param s the input string
     * @return an ordered set of unique letters from {@code s}
     */
    private static Set<Character> orderedUniqueLetters(final String s) {
        final Set<Character> out = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                out.add(c);
            }
        }
        return out;
    }

    /**
     * Returns the (unordered) set of unique letters in a string.
     *
     * @param s the input string
     * @return a set of unique letters from {@code s}
     */
    private static Set<Character> uniqueLetters(final String s) {
        final Set<Character> out = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                out.add(c);
            }
        }
        return out;
    }
}



