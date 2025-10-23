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
        System.out.println("Playing Sudoku");
	    System.out.println("The goal of Sudoku is to fill each space in the grid with");
	    System.out.println("a digit, 1 through 9. The only rule is that there can be");
		System.out.println("no recurring digits on any colomn, row, or subgrid of 3x3.");
        return Optional.empty();
    }
}
