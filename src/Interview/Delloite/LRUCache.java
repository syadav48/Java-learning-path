package Interview.Delloite;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        cache.put("Shyam", 5);
        cache.put("Ram", 6);
        cache.put("Rham", 12);
        cache.get("Ram");
        cache.put("Ghanshyam", 15);
        System.out.println(cache);

    }
}
