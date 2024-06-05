import exceptions.UnexpectedValueSizeException;

public interface CSVSerializer {
    void fromCSV(String line) throws UnexpectedValueSizeException;
    String toCSV();
}
