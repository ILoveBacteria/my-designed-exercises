import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class GameAnalyzer {
    private final List<Game> games;
    
    private GameAnalyzer(List<Game> games) {
        this.games = games;
    }
    
    public static GameAnalyser readFromCSV(String fileName) throws IOException {
        // TODO: Implement
        return null;
    }
    
    public List<Game> sortByRating() {
        // TODO: Implement
        return null;
    }
    
    public List<Game> topMostPlayedGames(int n) {
        // TODO: Implement
        return null;
    }
    
    public void deleteGames(Predicate<Game> filter) {
        // TODO: Implement
    }
    
    public int countReleasedGames(int year) {
        // TODO: Implement
        return 0;
    }
    
    public Optional<Integer> interestGenreInYear(int year, String genre) {
        // TODO: Implement
        return Optional.empty();
    }
    
    public Map<Integer, Integer> interestGenreChangeWithinYears(int fromYear, int toYear, String genre) {
        // TODO: Implement
        return null;
    }
    
    public List<Game> getGames() {
        return games;
    }
}
