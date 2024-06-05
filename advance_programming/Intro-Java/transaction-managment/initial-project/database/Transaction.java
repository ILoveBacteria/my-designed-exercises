import exceptions.UnexpectedValueSizeException;

import java.util.Objects;

public class Transaction {
    private String from;
    private String to;
    private int amount;
    private String reason;

    public Transaction(String line) throws UnexpectedValueSizeException {
        fromCSV(line);
    }

    public Transaction(String from, String to, int amount, String reason) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.reason = reason;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, amount, reason);
    }
}
