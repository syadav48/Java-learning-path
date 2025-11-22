package JavaCollectionTutorial.qns.Map;

public class Q9_LRUCache {
    public static void main(String[] args) {
        LRU_Cache<Integer, String> cache = new LRU_Cache<>(3);

        cache.putValue(1, "A");
        cache.putValue(2, "B");
        cache.putValue(3, "C");

        System.out.println(cache); // {1=A, 2=B, 3=C}

        cache.getValue(1); // Accessing 1 makes it MRU
        System.out.println(cache); // {2=B, 3=C, 1=A}

        cache.putValue(4, "D"); // Cache is full → remove LRU (2)
        System.out.println(cache); // {3=C, 1=A, 4=D}

        cache.getValue(3);
        cache.putValue(5, "E"); // Remove LRU (1)
        System.out.println(cache); //
    }
}
