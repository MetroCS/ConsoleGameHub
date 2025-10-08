import java.util.Optional;

/**
 * A simplified console version of the classic Snake game.
 * The player controls a "snake" that moves around a grid, collecting food
 *   and growing in length.
 * The game ends if the snake runs into itself or the edge of the grid.
 * <pre>
 * Simulate the game board with a 2D array.
 * Display the game using text-based output.
 * </pre>
 * @version 1
 */
class SnakeGame implements Game {
    @Override
    public String getName() {
        return "Snake";
    }

    @Override
    public Optional<Integer> play() {
        
        System.out.println( """
                Welcome To Snake

                How to Play:
                - Use WASD or Arrow keys to move.
                - Eat Food to Grow
                - Avoid the Walls
                """);

        return Optional.empty();
    }
}
