package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.TreeMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String file1, String file2) throws Exception {

        Path path1 = Paths.get(file1).toAbsolutePath().normalize();
        Path path2 = Paths.get(file2).toAbsolutePath().normalize();

        ObjectMapper mapper =  new ObjectMapper();
        TreeMap<String, Object> mapFile1 = mapper.readValue(Files.readString(path1), new TypeReference<>() { });
        TreeMap<String, Object> mapFile2 = mapper.readValue(Files.readString(path2), new TypeReference<>() { });

        var keys = new TreeSet(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        String result = "{\n";
        for (var key : keys) {
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                String value1 = mapFile1.get(key).toString();
                String value2 = mapFile2.get(key).toString();
                if (value1.equals(value2)) {
                    result += "    " + key + ": " + value1 + "\n";
                } else {
                    result += "  - " + key + ": " + value1 + "\n  + " + key + ": " + value2 + "\n";
                }
            } else if (mapFile1.containsKey(key) && !mapFile2.containsKey(key)) {
                String value1 = mapFile1.get(key).toString();
                result += "  - " + key + ": " + value1 + "\n";
            } else {
                String value2 = mapFile2.get(key).toString();
                result += "  + " + key + ": " + value2 + "\n";
            }
        }

        result += "}";
        return result;
    }


}
