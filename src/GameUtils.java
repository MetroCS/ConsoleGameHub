import java.util.Random;
import java.util.List;
/**
 * This utility class provides methods for use in multiple games.
 * For example, it contains a method for handling random word selection.
 */
public final class GameUtils {
    /**
     * Static instance used to generate random strings.
     */
    private static final Random RANDOM = new Random();

    /**
     * Prevent Instantiation.
     */
    private GameUtils() {
        throw new UnsupportedOperationException("class cannot be instantiated");
    }

    /**
     * Returns a random word from given list.
     *
     * @param words A list of words from which the random word will be selected.
     * @return A random word from the list or null if the list is null or empty.
     */
    public static String getRandomWord(final List<String> words) {
        if (words == null || words.isEmpty()) {
            return null;
            }
        return words.get(RANDOM.nextInt(words.size()));
     }
}
