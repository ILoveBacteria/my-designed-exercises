import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailService {
    private final List<Mail> mails = new ArrayList<>();
    private final List<User> registerUsers = new ArrayList<>();
    private static final MailService object = new MailService();
    
    private MailService() {
    }
    
    public boolean checkUser(User user) {
        return registerUsers.contains(user);
    }
    
    public List<Mail> getMails(User user) {
        List<Mail> mailList = mails.stream().filter(mail -> mail.getReceiver().equals(user)).collect(Collectors.toList());
        mailList.forEach(x -> x.setRead(true));
        return mailList;
    }
    
    public boolean addMail(Mail mail) {
        if (mail.getContent().length() > 255 || mail.getSender().allowedEmails <= 0) {
            return false;
        }
        mails.add(mail);
        mail.getSender().allowedEmails--;
        return true;
    }
    
    public static MailService getObject() {
        return object;
    }
}
