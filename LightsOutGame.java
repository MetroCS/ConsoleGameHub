import java.io.InputStream;
import java.util.Optional;

/**
 * A logic puzzle where each cell on a grid can be either "on" or "off".
 * Selecting a cell toggles it and its immediate neighbors.
 * The goal is to turn all the lights off in as few moves as possible.
 * @version 1
 */
class LightsOutGame implements Game {
    static int DEFAULT_BOARD_SIZE = 5;
    private LightsOutBoard board;
    private InputStream inputStream;

    // Default constructor
    public LightsOutGame() {
        this(System.in);
    }

    // Constructor with InputStream injection for testing
    public LightsOutGame(InputStream in) {
        this.inputStream = in;
        this.board = new LightsOutBoard(DEFAULT_BOARD_SIZE, DEFAULT_BOARD_SIZE);
    }

    // Constructor with InputStream and board injection for deterministic testing
    public LightsOutGame(InputStream in, LightsOutBoard board) {
        this.inputStream = in;
        this.board = board;
    }

    @Override
    public String getName() {
        return "Lights Out";
    }

    @Override
    public Optional<Integer> play() {
        System.out.println("Welcome to Lights Out!");
        System.out.println("The tiles have an 'on' or 'off' function.");
        System.out.println("Selecting a tile will change its state.");
        System.out.println("Tiles also change the state of neighboring tiles.");
        System.out.println("Turning them 'off' or 'on' as well.");
        System.out.println("Grid must be lit in as few turns as possible.");
        System.out.println("Good luck!");
        
        // TODO: Implement game loop (Task #91)
        // - Randomize board
        // - Display board
        // - Get user input
        // - Toggle cells
        // - Check win condition
        // - Handle quit/restart
        
        return Optional.empty();
    }

    /**
     * Nested inner class representing the Lights Out game board.
     * Holds the grid and toggling logic.
     */
    static class LightsOutBoard {
        private boolean[][] grid;
        private int numRows;
        private int numColumns;

        // Constructor with dimensions
        public LightsOutBoard(int numRows, int numColumns) {
            this.numRows = numRows;
            this.numColumns = numColumns;
            this.grid = new boolean[numRows][numColumns];
            // TODO: Initialize grid (all off by default)
        }

        // Copy constructor
        public LightsOutBoard(LightsOutBoard other) {
            this.numRows = other.numRows;
            this.numColumns = other.numColumns;
            this.grid = new boolean[numRows][numColumns];
            // TODO: Deep copy the grid from other
        }

        /**
         * Toggles specified cell and its neighbors.
         * @param row the row index (0-based)
         * @param column the column index (0-based)
         * @return true if toggle was successful, false otherwise
         */
        public boolean toggle(int row, int column) {
            // TODO: Implement toggle logic (Task #91)
            return false;
        }

        /**
         * Returns ASCII board display with row/column labels.
         * @return String representation of the board
         */
        public String display() {
            // TODO: Implement display logic (Task #91)
            return "";
        }

        /**
         * Gets the state of a cell.
         * @param row the row index
         * @param column the column index
         * @return true if light is on, false if off
         */
        boolean getCell(int row, int column) {
            // TODO: Implement getter (Task #91)
            return false;
        }

        /**
         * Sets the state of a cell.
         * @param row the row index
         * @param column the column index
         * @param value true to turn on, false to turn off
         */
        void setCell(int row, int column, boolean value) {
            // TODO: Implement setter (Task #91)
        }

        /**
         * Checks if all lights are off.
         * @return true if all lights are off, false otherwise
         */
        boolean allOff() {
            // TODO: Implement win condition check (Task #91)
            return false;
        }

        /**
         * Randomizes the board state.
         */
        void randomize() {
            // TODO: Implement randomization logic (Task #91)
        }
    }
}

