package helloInterview.lld.lruCache;

public class Node<K, V> {
    K key;
    V val;
    Node<K, V> prev, next;

    public Node(K key, V val){
        this.key = key;
        this.val = val;
    }
}
