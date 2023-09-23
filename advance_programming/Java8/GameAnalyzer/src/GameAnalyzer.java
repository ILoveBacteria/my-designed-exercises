import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameAnalyzer {
    private final List<Game> games;
    
    private GameAnalyzer(List<Game> games) {
        this.games = games;
    }
    
    public static GameAnalyzer readFromCSV(String fileName) throws IOException {
        List<Game>games=new ArrayList<>();
        Path path = Paths.get(fileName);
        List<String> list = Files.readAllLines(path);
        list.stream().map(a -> a.split(",")).forEach(b -> games.add(new Game(b[0],Integer.parseInt(b[1].split("-")[0]),Double.parseDouble(b[2]),List.of(b[3].split("-")),Integer.parseInt(b[4]))));
        return new GameAnalyzer(games);
    }
    
    public List<Game> sortByRating() {
        return games.stream().sorted((a,b)-> (int) (b.getRating()-a.getRating())).collect(Collectors.toList());
        
    }
    
    public List<Game> topMostPlayedGames(int n) {
        return games.stream().sorted((a,b)-> (int) (b.getPlays()-a.getPlays())).limit(n).collect(Collectors.toList());
    }
    
    public void deleteGames(Predicate<Game> filter) {
    
    }
    
    public int countReleasedGames(int year) {
        return (int) games.stream().filter(a -> a.getYear()==year).count();
    }
    
    public Optional<Integer> interestGenreInYear(int year, String genre) {
        return games.stream().filter(a -> a.getYear()==year).filter(a -> a.getGenres().contains(genre)).map(a -> a.getPlays()).reduce((a,b)-> a+b);
    }
    
    public Map<Integer, Integer> interestGenreChangeWithinYears(int fromYear, int toYear, String genre) {
        // TODO: Implement
        return null;
    }
    
    public List<Game> getGames() {
        return games;
    }
}
