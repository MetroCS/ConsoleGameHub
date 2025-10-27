import java.util.Optional;

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

    

    @Override
    public String getName() {
        return "Word Guess";
    }

    @Override
    public Optional<Integer> play() {

        /**
         Game Logic Pseudocode:
          int UserScore = 100; //initial score
          String WordToGuess = WordGenerator(); Generates word to guess
         while (MaxAttempts >= UserAttempts){
             prompt user for guess
             if guess is correct
                 return score
                 break
             else
                 increment userattempts
                 score = score - 10; reduce 10 points each missed attempt

                 
         }
          
          
         
         */
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
        return Optional.empty();
    }

    public String WordGenerator(){
        //Word generation logic to be implemented
        return "placeholder";
    }

    public boolean isValidGuess(String guess){
        //Guess validation logic to be implemented
        return true;
    }
}

