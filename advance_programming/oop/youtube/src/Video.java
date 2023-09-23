import java.util.ArrayList;
import java.util.List;

public class Video {
    private String title;
    private final User uploader;
    public int views = 0;
    private final int ageRestriction;
    private final List<Comment> comments = new ArrayList<>();
    
    public Video(String title, User uploader, int ageRestriction) {
        this.title = title;
        this.uploader = uploader;
        this.ageRestriction = ageRestriction;
    }
    
    public void submitComment(Comment comment) {
        comments.add(comment);
    }
    
    public int getAgeRestriction() {
        return ageRestriction;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public User getUploader() {
        return uploader;
    }
    
    public List<Comment> getComments() {
        return comments;
    }
}
