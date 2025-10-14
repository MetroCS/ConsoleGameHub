import java.util.Optional;

/**
 * A number placement puzzle on a 9x9 grid.
 * The objective is to fill the grid with digits from 1 to 9 so that each
 * column, row, and 3x3 subgrid contains all digits without repetition.
 * <pre>
 * Implements puzzle validation and a playable UI.
 * May also generate puzzles.
 * </pre>
 * @version 1
 */
class SudokuGame implements Game {
    @Override
    public String getName() {
        return "Sudoku";
    }

    @Override
    public Optional<Integer> play() {
	printIntro();

        System.out.println("");
        return Optional.empty();
    }

	private void printIntro() {
	System.out.println(
	"Sudoku is a 9x9 number puzzle. Fill the grid so each row, column, and 3x3 box " +
	"contains the digits 1-9 exactly once. Use logic to complete the board."); 

}


public static void main(String[] args) {
	SudokuGame game = new SudokuGame();
	game.play();

	}
} 
