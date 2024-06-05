import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Database<T extends CSVSerializer> {
    private final Path path;
    private final Class<T> clazz;
    private final long maxSize;

    public Database(Path path, long maxSize, Class<T> clazz) throws FileNotFoundException {
        // TODO: Implement
    }

    public Path getPath() {
        return path;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public long getMaxSize() {
        return maxSize;
    }
}
