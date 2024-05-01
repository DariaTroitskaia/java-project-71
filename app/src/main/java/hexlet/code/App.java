package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;
    @Option(names = {"-f", "--format"}, paramLabel = "FORMAT", description = "output format [default: stylish]")
    String format;
    @Override
    public Object call() throws Exception {
        try {
            System.out.println(Differ.generate(filepath1.toString(), filepath2.toString()));
            return null;
        } catch (IOException e) {
            if (!Files.exists(Path.of(filepath1))) {
                System.out.println("File '" + filepath1 + "' does not exist");
            } else {
                System.out.println("File '" + filepath2 + "' does not exist");
            }
            return null;
        }
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
