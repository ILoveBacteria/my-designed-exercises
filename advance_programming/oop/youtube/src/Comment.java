import java.time.LocalDateTime;

public class Comment {
    private final String text;
    private final User author;
    private final Video video;
    private final LocalDateTime createdAt = LocalDateTime.now();
    
    public Comment(String text, User author, Video video) {
        this.text = text;
        this.author = author;
        this.video = video;
    }
    
    public String getText() {
        return text;
    }
    
    public User getAuthor() {
        return author;
    }
    
    public Video getVideo() {
        return video;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
