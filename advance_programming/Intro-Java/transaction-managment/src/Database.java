import exceptions.MaximumFileSizeException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Database<T extends CSVSerializer> implements FileManager<T> {
    private final Path path;
    private final Class<T> clazz;
    private final long maxSize;

    public Database(Path path, long maxSize, Class<T> clazz) throws FileNotFoundException {
        if (path == null || !path.toFile().exists()) {
            throw new FileNotFoundException();
        }
        this.path = path;
        this.maxSize = maxSize;
        this.clazz = clazz;
    }

    @Override
    public List<T> getObjects() {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class);
            return Files.readAllLines(path).stream().map(x -> {
                try {
                    return constructor.newInstance(x);
                } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        } catch (IOException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> filterObjects(Predicate<T> predicate) {
        return getObjects().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void add(T obj) throws MaximumFileSizeException {
        try {
            long nextSize = Files.size(path) + obj.toCSV().length();
            if (nextSize > maxSize) {
                throw new MaximumFileSizeException(String.format("Max size %d bytes reached!", maxSize));
            }
            List<String> lines = Files.readAllLines(path);
            lines.add(obj.toCSV());
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(T obj) {
        try {
            List<T> objects = this.getObjects();
            List<String> lines = objects.stream().filter(x -> !x.equals(obj)).map(CSVSerializer::toCSV).collect(Collectors.toList());
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() {
        byte[] lines = {};
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
