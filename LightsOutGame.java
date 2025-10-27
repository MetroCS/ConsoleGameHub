import java.util.Optional;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Random;

/**
 * A logic puzzle where each cell on a grid can be either "on" or "off".
 * Selecting a cell toggles it and its immediate neighbors.
 * The goal is to turn all the lights off in as few moves as possible.
 *
 * Consider a model using a grid of booleans.
 * Implement toggling logic on that grid.
 *
 * @version 1
 */

public class LightsOutGame implements Game {
    /** Input source (injected for testing). */
    private final InputStream in;

    /** Output sink (defaults to System.out). */
    private final PrintStream out;

    /** Current board state. */
    private final LightsOutBoard board;

    /** Copy of original board used for restart. */
    private final LightsOutBoard boardCopy;

    /** Pseudo-random generator for board creation. */
    private final Random rng = new Random();

    /** Default number of rows for the board. */
    private static final int DEFAULT_ROWS = 5;

    /** Default number of columns for the board. */
    private static final int DEFAULT_COLS = 5;

    /**
     * No-argument constructor that delegates to the InputStream constructor.
     */
    public LightsOutGame() {
        //Stub: Write constructor
    }

    /**
     * Constructor that accepts an InputStream
     * for testability and uses a default board size.
     * @param inputStream the input stream to read commands from
     * (must not be null)
     */
    public LightsOutGame(final InputStream inputStream) {
        //Stub:Write constructor
    }
    /**
     * Full constructor that accepts an input
     * stream and a pre-constructed board.
     * This constructor supports deterministic tests
     * by allowing an injected board.
     * @param inputStream the input stream to read
     * commands from (must not be null)
     * @param initialBoard the initial board to use
     * for the game (must not be null)
     */
    public LightsOutGame(final InputStream inputStream,
                         final LightsOutBoard initialBoard) {
        //Stub: Write constructor
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Lights Out";
    }

    /**
     * Entry point for playing the game. This stub prints
     * the welcome text and returns empty.
     *
     * @return an Optional containing the number of moves
     * if the player solved the board; empty otherwise
     */
    @Override
    public Optional<Integer> play() {
        out.println("Welcome to Lights Out!");
        out.println("The tiles have an 'on' or 'off' function.");
        out.println("Selecting a tile will change its state.");
        out.println("Tiles also change the state of neighboring tiles.");
        out.println("Turning them 'off' or 'on' as well.");
        out.println("Grid must be lit in as few turns as possible.");
        out.println("Good luck!");
        return Optional.empty();
    }
    /**
     * Parse a player's move from free-form input
     * such as "2,3", "2 3", or "(2, 3)".
     *
     * @param input the raw input string from the player
     * @return an Optional containing a two-element int
     * array [row, col] when parsing succeeds; empty otherwise
     */
    private Optional<int[]> parseMove(final String input) {
        return Optional.empty();
    }
    /**
     * Internal representation of the lights-out board.
     */
    static class LightsOutBoard {
        /** Grid of cells; true means "on", false means "off". */
        private final boolean[][] grid;

        /** Number of rows in the grid. */
        private final int rows;

        /** Number of columns in the grid. */
        private final int cols;

        /**
         * Create a board with default dimensions (5x5).
         */
        LightsOutBoard() {
             //Stub: Write constructor
        }
        /**
         * Create a board with the specified number of rows and columns.
         *
         * @param numRows the number of rows
         * @param numColumns the number of columns
         */
        LightsOutBoard(final int numRows, final int numColumns) {
             //Stub: Write constructor
        }
        /**
         * Copy constructor.
         *
         * @param other the board to copy
         */
        LightsOutBoard(final LightsOutBoard other) {
            //Stub: Write constructor
        }
        /**
         * Toggle the specified cell and its immediate orthogonal neighbors.
         * Boundary cells only toggle neighbors that exist.
         *
         * @param row the row index to toggle
         * @param column the column index to toggle
         * @return true if the board is fully off after the toggle;
         * false otherwise
         */
        public boolean toggle(final int row, final int column) {
            return false;
        }
        /**
         * Produce a labeled ASCII representation of the board.
         *
         * @return a multi-line string containing the board display
         */
        public String display() {
            return "";
        }

        /**
         * Retrieve the state of a cell.
         *
         * @param row the row index
         * @param column the column index
         * @return true if the cell is on; false if it is off
         */
        boolean getCell(final int row, final int column) {
            return false;
        }

        /**
         * Set the state of a cell.
         *
         * @param row the row index
         * @param column the column index
         * @param value true to set the cell on; false for off
         */
        void setCell(final int row, final int column, final boolean value) {
            //Stub: Write cell setter
        }
        /**
         * Check whether all lights on the board are off.
         *
         * @return true when all cells are false; false otherwise
         */
        public boolean isSolved() {
            return false;
        }

    /**
     * Helper that produces solvable boards (stubbed).
     */
    static class BoardGenerator {
        /**
         * Generate a board that is guaranteed
         * solvable (stubbed implementation).
         *
         * @param rows the number of rows
         * @param cols the number of columns
         * @param rng the random generator to use
         * @return a solvable LightsOutBoard (currently a fresh empty board)
         */
        public LightsOutBoard generateSolvable(final int rows,
                        final int cols, final Random rng);
    }

    /**
     * Solver implementation (stubbed).
     */
    static class LightsOutSolver {
        /**
         * Determine whether the provided board
         * has a solution (stubbed implementation).
         *
         * @param board the board to analyze
         * @return true if the board is solvable, otherwise false
         */
        public boolean isSolvable(final LightsOutBoard board) {
            //Stub: implement solver
            return true;
        }
    }
  }
}
