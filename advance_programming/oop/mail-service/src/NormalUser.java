import java.util.List;

public class NormalUser implements User {
    private final String name;
    private int allowedEmails;
    
    public NormalUser(String name, int allowedEmails) {
        this.name = name;
        this.allowedEmails = allowedEmails;
    }
    
    @Override
    public boolean sendMail(Mail mail) {
        if (allowedEmails == 0) {
            return false;
        }
        if (MailService.getObject().sendMail(mail)) {
            allowedEmails--;
            return true;
        }
        return false;
    }
    
    @Override
    public List<Mail> inbox() {
        return MailService.getObject().getUserMails(this);
    }
}
