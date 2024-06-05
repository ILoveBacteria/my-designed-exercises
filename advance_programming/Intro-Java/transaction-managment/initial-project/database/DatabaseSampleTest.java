import exceptions.MaximumFileSizeException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseSampleTest {
    Path path = Path.of("transactions.csv");

    @Before
    public void begin() throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("Ali,Moein,100,Birthday gift");
        lines.add("Reza,Moein,5500,Birthday gift");
        lines.add("Ali,Hasan,5,buy pizza");
        Files.write(path, lines);
    }

    @Test
    public void testDatabaseAddObject() throws IOException, MaximumFileSizeException {
        List<String> beforeCreateDatabase = Files.readAllLines(path);
        Database<Transaction> database = new Database<>(path, 1000, Transaction.class);
        Transaction transaction = new Transaction("Tom Cruse", "Moein", 10, "have fun");
        database.add(transaction);
        List<String> afterAddUser = Files.readAllLines(path);
        beforeCreateDatabase.add("Tom Cruse,Moein,10,have fun");
        assertEquals(beforeCreateDatabase, afterAddUser);
    }
}
