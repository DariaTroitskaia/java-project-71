package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String format(List<Map<String, Object>> maps) {
        StringBuilder builder = new StringBuilder();
        Object keyValue;
        for (Map<String, Object> map : maps) {
            String key = map.get("key").toString();
            String operand = map.get("type").toString();
            keyValue = map.get("value");
            switch (operand) {
                case "deleted":
                    builder.append(String.format("Property '%s' was removed\n", key));
                    break;
                case "added":
                    builder.append(String.format("Property '%s' was added with value: %s\n",
                            key, valueToString(keyValue)));
                    break;
                case "unchanged":
                    break;
                case "changed":
                    builder.append(String.format("Property '%s' was updated. From %s to %s\n", key,
                            valueToString(map.get("value1")), valueToString(map.get("value2"))));
                    break;
                default:
                    throw new RuntimeException("Unexpected value: " + operand);
            }
        }
        builder.replace(builder.lastIndexOf("\n"), builder.length(), "");
        return builder.toString();
    }

    private static String valueToString(Object value) {
        if (value == null) { // String.valueOf может работать с null,
            // но тогда он возвращает его как строку "null" и не совпадает с тестами,
            // поэтому оставила отдельную обработку этого случая
            return null;
        } else if (value instanceof List<?> || value instanceof Map<?, ?>) {
            return "[complex value]";
        } else if (!(value instanceof Boolean) && !(value instanceof Number)) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}
