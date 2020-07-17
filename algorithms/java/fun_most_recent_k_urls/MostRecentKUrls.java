import java.net.URL;
import java.util.Map;

public class MostRecentKUrls {
    static class URLNode {
        String url;
        URLNode prev;
        URLNode next;
        URLNode(String url) {
            this.url = url;
        }
    }

    URLNode head;
    URLNode tail;
    int capacity;
    Map<String, URLNode> URLNodeMap;
    int size;

    MostRecentKUrls(int capacity) {
        if (capacity == 0) {
            throw new IllegalArgumentException("capacity cannot be 0");
        }
        this.capacity = capacity;
        URLNodeMap = new HashMap<>();
        size = 0;
    }

    public void update(String url) {
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        URLNode node = null;
        if (URLNodeMap.containsKey(url)) {
            node = URLNodeMap.get(url);
            remove(node);
            size--;
        } else if (size == capacity) {
            node = tail;
            remove(node);
            size--;
            node.url = url;
        } else {
            node = new URLNode(url);
        }
        append(node);
        size++;
    }

    public List<String> getMostRecentK() {
        List<String> topKRecentUrls = new ArrayList<>();
        URLNode curNode = head;
        while (curNode != null) {
            topKRecentUrls.add(curNode.url);
            curNode = curNode.next;
        }
        return topKRecentUrls;
    }

    private void append(UrlNode node) {
        URLNodeMap.put(node.url, node);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void remove(Node node) {
        URLNodeMap.remove(node.url);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.next = null;
        node.prev = null;
    }
}