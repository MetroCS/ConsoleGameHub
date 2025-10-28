import java.util.Optional;
import java.util.Scanner;
/**
 * A word guessing game similar to Wordle.
 * The player has a limited number of attempts to guess a secret
 * 5-letter word.
 * After each guess, the game indicates whether the guess is correct.
 * <br />
 * The score is determined by how many attempts the player had remaining
 *   when they guessed the word correctly.
 * @version 1
 */
class WordGuessGame implements Game {

// Acceots 5 Alphabetic letters ASCII A-Z or a-z.//
public String GuessCondition = "^[A-Za-z]{5}$";
// Maximum number of attempts a player gets //
public int MaxAttempts = 6;

/**
*Checks if a guess is valid, non-null, and alphabetic
*
*@param guess The user's guess.
*@return true if valid, false otherwise,
*/
boolean isValidGuess(String guess) {
	return guess != null && guess.matches(GuessCondition);
}
	@Override
    public String getName() {
        return "Word Guess";
    }

    @Override
    public Optional<Integer> play() {
        System.out.println(
            "[Playing Word Guess - You will have a limited number of attempts"
            + " to guess a secret 5 letter word.]"
        );
        System.out.println(
            "After each guess, the game will indicate whether the guess is"
            + " correct."
        );
        System.out.println(
            "Your score is determined by the number of attempts remaining"
            + " after you guessed the word correctly!"
        );

//Remaining attempts and user input// 
int attemptsLeft = MaxAttempts;
Scanner scanner = new Scanner(System.in);

//Loop will continue while player has attempts remaining//
while (attemptsLeft > 0) {
String guess;

//Loop prompts until a valid guess is entered//
while (true) {
	System.out.print
("Enter a 5-Letter Word: ");
	guess = scanner.nextLine();

	if (!isValidGuess(guess)) {
		System.out.println("Inavlid Input: Please enter 5 alphabetic letters (A-Z).");
		continue;
}
	guess = guess.toUpperCase();
	break;
}

//Valid input consumes one attempt//
attemptsLeft--;
System.out.println("Guess Accepted. Attempts Left: " + attemptsLeft);

break;

}

return Optional.empty();

}

}
