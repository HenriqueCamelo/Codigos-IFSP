package src.util;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GenericCsvExporter {

    private static final String DELIM = ";";

    
    public static <T> String exportToCsv(List<T> data, List<String> selectedFields, Class<T> clazz) {
        
        List<String> cols = selectedFields.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        
        sb.append(String.join(DELIM, cols)).append("\n");

        if (data == null || data.isEmpty()) {
            return sb.toString(); 
        }

        
        for (T item : data) {
            for (int i = 0; i < cols.size(); i++) {
                Object value = extractNestedProperty(item, cols.get(i)); 
                sb.append(sanitize(value));
                if (i < cols.size() - 1) sb.append(DELIM);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    

    private static Object extractNestedProperty(Object root, String path) {
        if (root == null || path == null || path.isEmpty()) return null;
        String[] parts = path.split("\\.");
        Object current = root;

        for (String part : parts) {
            if (current == null) return null;
            current = getPropertyValue(current, part);
            // se não achou nem campo nem getter, marcamos como ERRO para facilitar debug
            if (current == PropertyNotFound.INSTANCE) return "ERRO";
        }
        return current;
    }

    private static Object getPropertyValue(Object obj, String name) {
        
        Field f = getFieldRecursively(obj.getClass(), name);
        if (f != null) {
            try {
                f.setAccessible(true);
                return f.get(obj);
            } catch (IllegalAccessException ignored) { /* cai no getter */ }
        }

        
        String cap = name.substring(0, 1).toUpperCase() + name.substring(1);
        for (String prefix : new String[]{"get", "is"}) {
            try {
                Method m = obj.getClass().getMethod(prefix + cap);
                return m.invoke(obj);
            } catch (NoSuchMethodException ignored) {
            } catch (Exception e) {
                return "ERRO";
            }
        }

        return PropertyNotFound.INSTANCE;
    }

    private static Field getFieldRecursively(Class<?> type, String name) {
        Class<?> c = type;
        while (c != null) {
            try {
                return c.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                c = c.getSuperclass();
            }
        }
        return null;
    }

    private static String sanitize(Object v) {
        if (v == null) return "";
        
        String s = (v instanceof Enum) ? ((Enum<?>) v).name() : String.valueOf(v);
        if (s.contains("\"")) s = s.replace("\"", "\"\"");
        if (s.contains(DELIM) || s.contains("\n") || s.contains("\r")) {
            s = "\"" + s + "\"";
        }
        return s;
    }

    
    private enum PropertyNotFound { INSTANCE }
}
