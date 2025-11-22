package JavaCollectionTutorial.qns.Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU_Cache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRU_Cache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public V getValue(K key) {
        return super.get(key);
    }

    public void putValue(K key, V value) {
        super.put(key, value);
    }
}
