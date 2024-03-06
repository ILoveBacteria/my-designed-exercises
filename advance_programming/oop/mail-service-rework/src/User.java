import java.util.List;

public interface User {
    boolean sendMail(Mail mail);
    List<Mail> inbox();
}
