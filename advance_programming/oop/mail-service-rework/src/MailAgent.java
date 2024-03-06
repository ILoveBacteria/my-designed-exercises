public class MailAgent {
    private final User user;
    
    public MailAgent(User user) {
        this.user = user;
    }
    
    public void sendMail(String message, User receiver) {
        Mail mail = new Mail(user, receiver, message);
    }
    
    public void receiveMail(Mail mail) {
        System.out.println(mail);
    }
}
