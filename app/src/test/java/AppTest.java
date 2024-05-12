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
    private static String trueResultEmptyStilish;
    private static String trueResultJSON;
    private static String trueResultPlain;
    @BeforeAll
    static void loadAllReferenceStrings() throws IOException {
        trueResultStilish = Files.readString(Paths.get("src/test/resources/resultStylish.txt")
                .toAbsolutePath().normalize());
        trueResultEmptyStilish = Files.readString(Paths.get("src/test/resources/resultStylishWithEmpty.txt")
                .toAbsolutePath().normalize());
        trueResultJSON = Files.readString(Paths.get("src/test/resources/resultJSON.txt")
                .toAbsolutePath().normalize());
        trueResultPlain = Files.readString(Paths.get("src/test/resources/resultPlain.txt")
                .toAbsolutePath().normalize());
    }

    static String readStringFromFile(String fileNameOrFullPath) throws IOException {
        Path absolutePath = Paths.get(fileNameOrFullPath).toAbsolutePath().normalize();
        return Files.readString(absolutePath);
    }

    static String getTestFilePath(String filename) {
        return String.valueOf(Paths.get("src/test/resources/" + filename)
                .toAbsolutePath().normalize());
    }

    static String getTestStr(String filename1, String filename2) throws Exception {
        String filepath1 = getTestFilePath(filename1);
        String filepath2 = getTestFilePath(filename2);

        String testStr = "";
        testStr = Differ.generate(filepath1, filepath2);

        return testStr;
    }

    static String getTestStr(String filename1, String filename2, String format) throws Exception {
        String filepath1 = getTestFilePath(filename1);
        String filepath2 = getTestFilePath(filename2);

        String testStr = "";
        testStr = Differ.generate(filepath1, filepath2, format);

        return testStr;
    }
    @Test
    public void jsonFilesStylishTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultStilish;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.json", "testFile2.json", "stylish"));
    }

    @Test
    public void ymlFilesStylishTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultStilish;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.yml", "testFile2.yml", "stylish"));
    }

    @Test
    public void emptyFileStylishTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultEmptyStilish;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.json", "emptyFile.json"));
    }
    @Test
    public void jsonToPlainTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultPlain;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.json", "testFile2.json", "plain"));
    }
    @Test
    public void ymlToPlainTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultPlain;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.yml", "testFile2.yml", "plain"));
    }
    @Test
    public void jsonToJsonTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultJSON;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.json", "testFile2.json", "json"));
    }
    @Test
    public void ymlToJsonTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultJSON;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.yml", "testFile2.yml", "json"));
    }
    @Test
    public void ymlToDefaultTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultStilish;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.yml", "testFile2.yml"));
    }
    @Test
    public void jsonToDefaultTest() throws Exception {
        String expectedStylish = "";
        try {
            expectedStylish = trueResultStilish;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, getTestStr("testFile1.json", "testFile2.json"));
    }
}
