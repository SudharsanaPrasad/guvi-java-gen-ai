package warmup.cache;

import java.util.HashMap;
import java.util.Map;

public class RawCache<K, V> {
    // hashmap -> (key, value)
    private Map<K, V> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        //
        RawCache<String, String> cache = new RawCache<>();
        cache.put("homepage", "<html>Home</html>");

        RawCache<String, Integer> cache2 = new RawCache<>();
        cache2.put("userCount", 100);
        //cache.put("test", true);

        // Risky casting
//        int count = (int) cache.get("userCount");
//        String html = (String) cache.get("homepage");
//        String fail = (String) cache.get("userCount"); // Consider: What happens here?
        Integer count = cache2.get("userCount");
        // Students, Professors, Admins -> Person
        // Products
    }
}
