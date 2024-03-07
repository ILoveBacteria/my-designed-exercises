import java.util.Objects;

public class Mail {
    private final User sender;
    private final User receiver;
    private final String content;
    private boolean read = false;
    
    public Mail(User sender, User receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }
    
    public User getSender() {
        return sender;
    }
    
    public User getReceiver() {
        return receiver;
    }
    
    public String getContent() {
        return content;
    }
    
    public boolean isRead() {
        return read;
    }
    
    public void setRead(boolean read) {
        this.read = read;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        if (!Objects.equals(sender, mail.sender)) return false;
        if (!Objects.equals(receiver, mail.receiver)) return false;
        return Objects.equals(content, mail.content);
    }
    
    @Override
    public String toString() {
        return "sender=" + sender.getName() +
                ", receiver=" + receiver.getName() +
                ", content=" + content;
    }
}
