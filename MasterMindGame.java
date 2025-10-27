import java.util.Optional;
import java.util.*;

/**
 * A code-breaking game where the app selects a sequence of symbols, and
 * the player tries to guess the sequence within a fixed number of attempts.
 *
 * Feedback for each guess indicates how many values are correct and in
 * the correct position and how many are correct but in the wrong position.
 *
 * Consider using arrays or strings to store and compare codes.
 * @version 1
 */
class MasterMindGame implements Game {
    @Override
    public String getName() {
        return "MasterMind";
    }

    @Override
    public Optional<Integer> play() {
        System.out.println("[Playing MasterMind - Placeholder]");
        return Optional.empty();
    }
}

class CodeGenerator {
        public static String generateCode() {
            Random random = new Random();
            String numbers = "0123456789";
            String code = "";

            for (int i=0; i < 4; i++) {
                int index = random.nextInt(numbers.length());
                code = code + numbers.charAt(index);
            }

            return code;
        }
    }
