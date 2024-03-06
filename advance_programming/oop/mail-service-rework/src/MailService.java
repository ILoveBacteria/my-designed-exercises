import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailService {
    private final List<Mail> mails = new ArrayList<>();
    private static final MailService object = new MailService();
    
    private MailService() {
    }
    
    public List<Mail> getAllMails() {
        return mails;
    }
    
    public List<Mail> getUserMails(User user) {
        return mails.stream().filter(mail -> mail.getReceiver().equals(user)).collect(Collectors.toList());
    }
    
    public boolean sendMail(Mail mail) {
        if (mail.getSender() instanceof NormalUser &&
                mail.getReceiver() instanceof SuperUser ||
                mail.getContent().length() > 255) {
            return false;
        }
        mails.add(mail);
        return true;
    }
    
    public static MailService getObject() {
        return object;
    }
}
