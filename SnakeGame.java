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
        System.out.println("Welcome to Snake!");
        System.out.println("Objective: Survive as long as you can!");
        System.out.println("How to play: Grow by eating dots and avoid walls");
        System.out.println("or you die");
        return Optional.empty();
    }
}
