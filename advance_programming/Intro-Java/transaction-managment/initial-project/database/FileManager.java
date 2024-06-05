import exceptions.MaximumFileSizeException;

import java.util.List;
import java.util.function.Predicate;

public interface FileManager<T extends CSVSerializer> {
    List<T> getObjects();
    void add(T obj) throws MaximumFileSizeException;
    void delete(T obj);
    void deleteAll();
    List<T> filterObjects(Predicate<T> predicate);
}
