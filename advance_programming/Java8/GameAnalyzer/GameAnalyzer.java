import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameAnalyzer {
    private final List<Game> games;
    
    private GameAnalyzer(List<Game> games) {
        this.games = games;
    }
    
    public static GameAnalyzer readFromCSV(String fileName) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<Game> values = lines
                    .skip(1)
                    .map(x -> x.split(","))
                    .map(GameAnalyzer::convertToGame)
                    .distinct()
                    .collect(Collectors.toList());
            return new GameAnalyzer(values);
        }
    }
    
    private static Game convertToGame(String[] d) {
        return new Game(
                d[0],
                Integer.parseInt(d[1].split("-")[2]),
                Double.parseDouble(d[2]),
                Arrays.asList(d[3].split("-")),
                Integer.parseInt(d[4])
        );
    }
    
    public List<Game> sortByRating() {
        return games.stream().sorted((y, x) -> Double.compare(x.getRating(), y.getRating())).collect(Collectors.toList());
    }
    
    public List<Game> topMostPlayedGames(int n) {
        return games.stream()
                .sorted((y, x) -> Integer.compare(x.getPlays(), y.getPlays()))
                .limit(n)
                .collect(Collectors.toList());
    }
    
    public void deleteGames(Predicate<Game> filter) {
        games.removeIf(filter);
    }
    
    public int countReleasedGames(int year) {
        return (int) games.stream().filter(x -> x.getYear() == year).count();
    }
    
    public Optional<Integer> interestGenreInYear(int year, String genre) {
        return games.stream()
                .filter(x -> x.getYear() == year && x.getGenres().contains(genre))
                .map(Game::getPlays)
                .reduce(Integer::sum);
    }
    
    public Map<Integer, Integer> interestGenreChangeWithinYears(int fromYear, int toYear, String genre) {
        Map<Integer, Integer> result = new HashMap<>();
        IntStream.rangeClosed(fromYear, toYear)
                .forEach(x -> result.put(x, this.interestGenreInYear(x, genre).get()));
        return result;
    }
    
    public List<Game> getGames() {
        return games;
    }
}


