import java.util.Arrays;

public class HashMap<K, V> {
    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] array;
    private int size;
    private float loadFactor;

    HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    HashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity cannot be equal or smaller than 0");
        }
        this.array = (Node<K, V>[]) (new Node[cap]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
            return size;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0x7FFFFFFF;
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsKey(K k1, K k2) {
        return k1 == k2 || k1 != null && k1.equals(k2);
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    
    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> node = head;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                V res = node.value;
                node.value = value;
                return res;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
        size++;
        if (needReHashing()) {
            rehashing();
        }
        return null;
    }

    private boolean needReHashing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void rehashing() {
        Node<K, V>[] old = array;
        array = (Node<K, V>[]) (new Node[old.length * 2]);
        size = 0;
        for (Node<K, V> node : old) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }
}

