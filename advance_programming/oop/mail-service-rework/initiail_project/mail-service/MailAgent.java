public class MailAgent {
    private final User user;
    
    private MailAgent(User user) {
        this.user = user;
    }
    
    public static MailAgent createAgent(User user) {
        // TODO: Implement
    }
    
    public boolean sendMail(String message, User receiver) {
        // TODO: Implement
    }
    
    public String receiveMail() {
        // TODO: Implement
    }
}
