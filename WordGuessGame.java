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
	int NumberOfGuesses = 6;
	Scanner input = new Scanner(System.in);
	String secretWord = "APPLE";
	
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
		
		String guess = EnterGuess();
		guess = GuessData(guess);
		NumberOfGuesses--;
		return Optional.of(NumberOfGuesses);
    }
	public String EnterGuess(){
		System.out.println("enter your 5 letter guess");
		return input.nextLine();
}

	public String GuessData(String guess){
		int guessLength = guess.length();
		if (guessLength != 5 || !guess.matches("[a-zA-Z0-9]{5}")){
			System.out.println("your guess needs to be 5 letters long");
			guess = EnterGuess();
			guess = GuessData(guess);
			return guess;
	}else {
		return guess;
	}
}
}
