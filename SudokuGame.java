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
        System.out.println("[Playing Sudoku - Placeholder]");
	System.out.println("Welcome to Sudoku! You will be presented with"
                        + " a 9x9 grid split into 9 different 3x3 grids."
                        + " Some of the cells will already be filled in"
                        + " with numbers. Each digit from 1-9 must"
                        + " appear exactly once in every"
                        + " row, column, and  3x3 grid. To solve the puzzle,"
                        + " each cell must be filled in according to the"
                        + " following conditions");

        return Optional.empty();

	}
}
