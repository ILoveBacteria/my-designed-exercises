import java.util.List;
import java.util.Objects;

public class Game {
    private final String title;
    private final int year;
    private final double rating;
    private final List<String> genres;
    private final int plays;
    
    public Game(String title, int year, double rating, List<String> genres, int plays) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
        this.plays = plays;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getYear() {
        return year;
    }
    
    public double getRating() {
        return rating;
    }
    
    public List<String> getGenres() {
        return genres;
    }
    
    public int getPlays() {
        return plays;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Game game = (Game) o;
        
        if (year != game.year) return false;
        if (Double.compare(game.rating, rating) != 0) return false;
        if (plays != game.plays) return false;
        if (!Objects.equals(title, game.title)) return false;
        return Objects.equals(genres, game.genres);
    }
    
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + year;
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + plays;
        return result;
    }
    
    @Override
    public String toString() {
        return title;
    }
}
