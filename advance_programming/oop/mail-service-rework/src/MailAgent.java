public class MailAgent {
    private final User user;
    
    private MailAgent(User user) {
        this.user = user;
    }
    
    public MailAgent createAgent(User user) {
        boolean valid = MailService.getObject().checkUser(user);
        if (!valid) {
            return null;
        }
        return new MailAgent(user);
    }
    
    public void sendMail(String message, User receiver) {
        Mail mail = new Mail(user, receiver, message);
    }
    
    public void receiveMail(Mail mail) {
        System.out.println(mail);
    }
}
