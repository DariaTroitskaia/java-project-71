import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    /**
     * @param format
     * @throws Exception
     */
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void jsonFilesStylishTest(String format) throws Exception {
        String normalPath1 = normalizePath("testFile1." + format);
        String normalPath2 = normalizePath("testFile2." + format);
        assertEquals(trueResultStilish, Differ.generate(normalPath1, normalPath2, "stylish"));
    }

/*
    @Test
    public void ymlFilesStylishTest() throws Exception {
        String normalPath1 = normalizePath("testFile1.yml");
        String normalPath2 = normalizePath("testFile2.yml");
        assertEquals(trueResultStilish, Differ.generate(normalPath1, normalPath2, "stylish"));
    }
*/


    /**
     * @param format
     * @throws Exception
     */
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void jsonToPlainTest(String format) throws Exception {
        String normalPath1 = normalizePath("testFile1." + format);
        String normalPath2 = normalizePath("testFile2." + format);
        assertEquals(trueResultPlain, Differ.generate(normalPath1, normalPath2, "plain"));
    }

    /**
     * @param format
     * @throws Exception
     */
/*
    @Test
    public void ymlToPlainTest() throws Exception {
        String normalPath1 = normalizePath("testFile1.yml");
        String normalPath2 = normalizePath("testFile2.yml");
        assertEquals(trueResultPlain, Differ.generate(normalPath1, normalPath2, "plain"));
    }
*/
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void jsonToJsonTest(String format) throws Exception {
        String normalPath1 = normalizePath("testFile1." + format);
        String normalPath2 = normalizePath("testFile2." + format);
        assertEquals(trueResultJSON, Differ.generate(normalPath1, normalPath2, "json"));
    }

    /**
     * @param format 
     * @throws Exception
     */
//    @Test
//    public void ymlToJsonTest() throws Exception {
//        String normalPath1 = normalizePath("testFile1.yml");
//        String normalPath2 = normalizePath("testFile2.yml");
//        assertEquals(trueResultJSON, Differ.generate(normalPath1, normalPath2, "json"));
//    }
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void ymlToDefaultTest(String format) throws Exception {
        String normalPath1 = normalizePath("testFile1." + format);
        String normalPath2 = normalizePath("testFile2." + format);
        assertEquals(trueResultStilish, Differ.generate(normalPath1, normalPath2));
    }
//    @Test
//    public void jsonToDefaultTest() throws Exception {
//        String normalPath1 = normalizePath("testFile1.json");
//        String normalPath2 = normalizePath("testFile2.json");
//        assertEquals(trueResultStilish, Differ.generate(normalPath1, normalPath2));
//    }
}
