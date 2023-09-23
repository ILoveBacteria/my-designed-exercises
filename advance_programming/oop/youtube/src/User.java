import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private final String username;
    private final LocalDate birthdate;
    private final List<Video> videos = new ArrayList<>();
    
    public User(String name, String username, String birthdate) {
        this.name = name;
        this.username = username;
        this.birthdate = LocalDate.parse(birthdate);
    }
    
    public int age() {
        LocalDate now = LocalDate.now();
        return now.getYear() - birthdate.getYear();
    }
    
    public boolean watchVideo(Video video) {
        if (video.getAgeRestriction() != -1 && video.getAgeRestriction() > age() && this != video.getUploader()) {
            return false;
        }
        video.views++;
        return true;
    }
    
    public void comment(Video video, String text) {
        Comment comment = new Comment(text, this, video);
        video.submitComment(comment);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public LocalDate getBirthdate() {
        return birthdate;
    }
    
    public List<Video> getVideos() {
        return videos;
    }
}
