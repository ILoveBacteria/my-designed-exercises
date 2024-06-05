import exceptions.UnexpectedValueSizeException;

import java.util.Objects;

public class User implements CSVSerializer {
    private String name;
    private String password;
    private String email;
    private String phone;
    private int balance;

    public User(String line) throws UnexpectedValueSizeException {
        fromCSV(line);
    }

    public User(String name, String password, String email, String phone, int balance) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public void fromCSV(String line) throws UnexpectedValueSizeException {
        String[] split = line.split(",");
        if (split.length != 5) {
            throw new UnexpectedValueSizeException("Needs 5 values but got " + split.length);
        }
        this.name = split[0];
        this.password = split[1];
        this.email = split[2];
        this.phone = split[3];
        this.balance = Integer.parseInt(split[4]);
    }

    public String toCSV() {
        return String.join(",",
                this.getName(),
                this.getPassword(),
                this.getEmail(),
                this.getPhone(),
                String.valueOf(this.getBalance())
        );
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return balance == user.balance && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email, phone, balance);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
