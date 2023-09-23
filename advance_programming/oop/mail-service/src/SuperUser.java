import java.util.List;

public class SuperUser implements User {
    private final String name;
    
    public SuperUser(String name) {
        this.name = name;
    }
    
    @Override
    public boolean sendMail(Mail mail) {
        return MailService.getObject().sendMail(mail);
    }
    
    @Override
    public List<Mail> inbox() {
        return MailService.getObject().getAllMails();
    }
}
