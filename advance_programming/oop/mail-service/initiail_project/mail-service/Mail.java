public class Mail {
    private final User sender;
    private final User receiver;
    private final String content;
    
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
    
    @Override
    public boolean equals(Object o) {
        // TODO: Implement
    }
}
