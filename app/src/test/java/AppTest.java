import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private final String filepath1Json = "src/test/resources/testFile1.json";
    private final String filepath2Json = "src/test/resources/testFile2.json";
    private final String filepath1Yml = "src/test/resources/testFile1.yml";
    private final String filepath2Yml = "src/test/resources/testFile2.yml";
    private final String emptyFile = "src/test/resources/emptyFile.json";
    private final String trueResultStilish = "src/test/resources/resultStilish.txt";
    private final String trueResultEmptyStilish = "src/test/resources/resultStilishWithEmpty.txt";

    @Test
    public void jsonFilesStylishTest() throws Exception {
        Path fullPath = Paths.get(trueResultStilish).toAbsolutePath().normalize();
        String expectedStylish = "";
        try {
            expectedStylish = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, Differ.generate(filepath1Json, filepath2Json));
    }

    @Test
    public void ymlFilesStylishTest() throws Exception {
        Path fullPath = Paths.get(trueResultStilish).toAbsolutePath().normalize();
        String expectedStylish = "";
        try {
            expectedStylish = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, Differ.generate(filepath1Yml, filepath2Yml));
    }

    @Test
    public void emptyFileStylishTest() throws Exception {
        Path fullPath = Paths.get(trueResultEmptyStilish).toAbsolutePath().normalize();
        String expectedStylish = "";
        try {
            expectedStylish = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, Differ.generate(filepath1Json, emptyFile));
    }
}
