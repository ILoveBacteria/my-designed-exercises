import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileOrganizer {
    private static final List<String> known = Arrays.asList("jpg", "mp4", "mp3");
    
    private FileOrganizer() {}
    
    public static void removeUnknownExtensions(Path path) {
        for (File file : path.toFile().listFiles()) {
            try {
                if (!known.contains(getExtension(file.toPath()))) {
                    file.delete();
                }
            } catch (PathIsDirectoryException ignore) {}
        }
    }
    
    public static String getExtension(Path path) throws PathIsDirectoryException {
        if (path.toFile().isDirectory()) {
            throw new PathIsDirectoryException();
        }
        String name = path.getFileName().toString();
        
        return name.substring(name.indexOf(".") + 1);
    }
    
    public static void organize(Path path) {
        removeUnknownExtensions(path);
        File dir = path.toFile();
        File images = path.resolve("images").toFile();
        File musics = path.resolve("musics").toFile();
        File videos = path.resolve("videos").toFile();
        images.mkdir();
        musics.mkdir();
        videos.mkdir();
        for (File file : dir.listFiles()) {
            try {
                String ext = getExtension(file.toPath());
                if (ext.equals("jpg"))
                    file.renameTo(new File(images, file.getName()));
                else if (ext.equals("mp3"))
                    file.renameTo(new File(musics, file.getName()));
                else
                    file.renameTo(new File(videos, file.getName()));
            } catch (PathIsDirectoryException ignore) {
            }
        }
    }
    
    public static List<File> sortFilesBySize(Path path) {
        File[] files = path.toFile().listFiles();
        List<File> result = Arrays.asList(files);
        result.sort((a, b) -> Long.compare(b.length(), a.length()));
        return result;
    }
}
