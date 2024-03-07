import java.util.stream.Collectors;

public class MailAgent {
    private final User user;
    
    private MailAgent(User user) {
        this.user = user;
    }
    
    public static MailAgent createAgent(User user) {
        boolean valid = MailService.getObject().checkUser(user);
        if (!valid) {
            return null;
        }
        return new MailAgent(user);
    }
    
    public boolean sendMail(String message, User receiver) {
        Mail mail = new Mail(user, receiver, message);
        return MailService.getObject().addMail(mail);
    }
    
    public String receiveMail() {
        return MailService.getObject().getMails(user).stream().map(Mail::toString).collect(Collectors.joining("\n"));
    }
}
