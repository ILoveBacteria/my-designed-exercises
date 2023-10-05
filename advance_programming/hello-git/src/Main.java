import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;

public class Main {
    private static final String envPath = "C:/Users/asus/Documents/test_env";
    
    public static void main(String[] args) throws IOException, GitAPIException {
        System.exit(2);
        //String envPath = args[1];
        //System.out.println(envPath);
        Path path = Paths.get(envPath + "/.git");
        Git.open(path.toFile()).reset().setMode(ResetCommand.ResetType.HARD).setRef("HEAD~2").call();
        Arrays.equals(
                Files.readAllBytes(Paths.get("Calculator.txt")),
                Files.readAllBytes(Paths.get(envPath, "src", "Calculator.java"))
        );
    }
}
