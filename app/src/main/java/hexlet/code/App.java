package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable{

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private File filepath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private File filepath2;
    @Option(names = {"-f", "--format"}, paramLabel = "FORMAT", description = "output format [default: stylish]")
    String format;
    @Override
    public Object call() throws Exception{
        System.out.println(Differ.generate(filepath1.toString(), filepath2.toString()));
        return null;
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
