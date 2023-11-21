public class NormalUser {
    private final String name;
    private int allowedEmails;
    
    public NormalUser(String name, int allowedEmails) {
        this.name = name;
        this.allowedEmails = allowedEmails;
    }
}
