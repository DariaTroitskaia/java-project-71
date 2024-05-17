import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static String trueResultStilish;
    private static String trueResultJSON;
    private static String trueResultPlain;
    @BeforeAll
    static void loadAllReferenceStrings() throws IOException {
        trueResultStilish = readStringFromFile("src/test/resources/resultStylish.txt");
        trueResultJSON = readStringFromFile("src/test/resources/resultJSON.txt");
        trueResultPlain = readStringFromFile("src/test/resources/resultPlain.txt");
    }

    static String readStringFromFile(String fileNameOrFullPath) throws IOException {
        Path absolutePath = Paths.get(fileNameOrFullPath).toAbsolutePath().normalize();
        return Files.readString(absolutePath);
    }

    static String normalizePath(String filename) {
        return String.valueOf(Paths.get("src/test/resources/" + filename)
                .toAbsolutePath().normalize());
    }

    @Test
    public void jsonFilesStylishTest() throws Exception {
        String expectedStylish = "";
        expectedStylish = trueResultStilish;
        String normalPath1 = normalizePath("testFile1.json");
        String normalPath2 = normalizePath("testFile2.json");
        assertEquals(expectedStylish, Differ.generate(normalPath1, normalPath2, "stylish"));
    }

    @Test
    public void ymlFilesStylishTest() throws Exception {
        String expectedStylish = "";
        expectedStylish = trueResultStilish;
        String normalPath1 = normalizePath("testFile1.yml");
        String normalPath2 = normalizePath("testFile2.yml");
        assertEquals(expectedStylish, Differ.generate(normalPath1, normalPath2, "stylish"));
    }

    @Test
    public void jsonToPlainTest() throws Exception {
        String expectedStylish = "";
        expectedStylish = trueResultPlain;
        String normalPath1 = normalizePath("testFile1.json");
        String normalPath2 = normalizePath("testFile2.json");
        assertEquals(expectedStylish, Differ.generate(normalPath1, normalPath2, "plain"));
    }
    @Test
    public void ymlToPlainTest() throws Exception {
        String expectedStylish = "";
        expectedStylish = trueResultPlain;
        String normalPath1 = normalizePath("testFile1.yml");
        String normalPath2 = normalizePath("testFile2.yml");
        assertEquals(expectedStylish, Differ.generate(normalPath1, normalPath2, "plain"));
    }
    @Test
    public void jsonToJsonTest() throws Exception {
        String expectedStylish = "";
        expectedStylish = trueResultJSON;
        String normalPath1 = normalizePath("testFile1.json");
        String normalPath2 = normalizePath("testFile2.json");
        assertEquals(expectedStylish, Differ.generate(normalPath1, normalPath2, "json"));
    }
    @Test
    public void ymlToJsonTest() throws Exception {
        String expectedStylish = "";
        expectedStylish = trueResultJSON;
        String normalPath1 = normalizePath("testFile1.yml");
        String normalPath2 = normalizePath("testFile2.yml");
        assertEquals(expectedStylish, Differ.generate(normalPath1, normalPath2, "json"));
    }
    @Test
    public void ymlToDefaultTest() throws Exception {
        String expectedStylish = "";
        expectedStylish = trueResultStilish;
        String normalPath1 = normalizePath("testFile1.yml");
        String normalPath2 = normalizePath("testFile2.yml");
        assertEquals(expectedStylish, Differ.generate(normalPath1, normalPath2));
    }
    @Test
    public void jsonToDefaultTest() throws Exception {
        String expectedStylish = "";
        expectedStylish = trueResultStilish;
        String normalPath1 = normalizePath("testFile1.json");
        String normalPath2 = normalizePath("testFile2.json");
        assertEquals(expectedStylish, Differ.generate(normalPath1, normalPath2));
    }
}
