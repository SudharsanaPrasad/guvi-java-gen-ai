package warmup.cache;

import java.util.HashMap;
import java.util.Map;

public class RawCache {
    private Map<String, Object> cache = new HashMap<>();

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        RawCache cache = new RawCache();
        cache.put("userCount", 100);
        cache.put("homepage", "<html>Home</html>");

        // Risky casting
        int count = (int) cache.get("userCount");
        String html = (String) cache.get("homepage");
        String fail = (String) cache.get("userCount"); // Consider: What happens here?
    }
}
