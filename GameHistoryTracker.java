import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Track history and stats of games played.
 * @author Jody Paul (assisted by chatGPT)
 * @author Cesar Soto, Mason Proctor, Luke Ross
 * @version 2
 */
public class GameHistoryTracker implements Serializable {
    private static final long serialVersionUID = 5L;

    /** Collection of play stats for each game. */
    private final HashMap<String, GameStats> statsMap = new HashMap<>();

    /**
     * Records a play session for a game.
     * @param gameName the name of the game played
     * @param score optional numeric score (nullable)
     */
    public void recordPlay(final String gameName, final Integer score) {
        GameStats stats = statsMap.getOrDefault(gameName, new GameStats());
        stats.incrementTimesPlayed();

        if (score != null) {
            stats.addScore(score); // adds score AND updates lastPlayed
        } else {
            stats.updateLastPlayed(); // update timestamp even if no score
        }

        statsMap.put(gameName, stats);
    }

    /**
     * Displays a summary of play history, showing average score, last score, and last played timestamp.
     */
    public void displayHistory() {
        System.out.println("\n=== Game Play History ===");
        if (statsMap.isEmpty()) {
            System.out.println("No games played yet.");
            return;
        }

        for (Map.Entry<String, GameStats> entry : statsMap.entrySet()) {
            String game = entry.getKey();
            GameStats stats = entry.getValue();
            System.out.printf("%s - Played: %d", game, stats.timesPlayed);

            if (!stats.scores.isEmpty()) {
                double avg = stats.getAverageScore();
                int lastScore = stats.getLastScore();
                System.out.printf(", Avg Score: %.2f, Last Score: %d", avg, lastScore);
            }

            System.out.printf(", Last Played: %s", stats.getLastPlayedFormatted());
            System.out.println();
        }
    }

    /**
     * Saves the game history to a file.
     * @param filename the name of the file to save to
     * @throws IOException if an I/O error occurs
     */
    public void saveHistory(final String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
        }
    }

    /**
     * Clears the history file.
     * @param filename takes name of file to clear history from.
     */
    public void clearHistory(final String filename) {
        statsMap.clear();
        try {
            saveHistory(filename);
        } catch (IOException e) {
            System.out.println("Game history save failed: " + e.getMessage());
        }
    }

    /**
     * Loads the game history from a file.
     * @param filename the name of the file to load from
     * @return a GameHistoryTracker instance
     */
    public static GameHistoryTracker loadHistory(final String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (GameHistoryTracker) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No previous history found or failed to load. Starting fresh.");
            return new GameHistoryTracker();
        }
    }

    /**
     * Inner class to track stats for a single game.
     */
    private static class GameStats implements Serializable {
        private static final long serialVersionUID = 5L;

        private int timesPlayed = 0;
        private int totalScore = 0;
        private ArrayList<Integer> scores = new ArrayList<>();
        private long lastPlayed = 0;

        int getTimesPlayed() { return this.timesPlayed; }
        void incrementTimesPlayed() { this.timesPlayed++; }

        void addScore(int score) {
            scores.add(score);
            totalScore += score;
            updateLastPlayed();
        }

        int getLastScore() {
            if (scores.isEmpty()) return 0;
            return scores.get(scores.size() - 1);
        }

        double getAverageScore() {
            if (scores.isEmpty()) return 0;
            return totalScore / (double) scores.size();
        }

        void updateLastPlayed() {
            this.lastPlayed = System.currentTimeMillis();
        }

        String getLastPlayedFormatted() {
            if (lastPlayed == 0) return "Never";
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy – h:mm a");
            return sdf.format(new Date(lastPlayed));
        }
    }
}
