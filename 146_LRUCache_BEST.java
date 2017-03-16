class DNode {
    int key;
    int val;
    DNode pre;
    DNode next;
    public DNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class LRUCache {
    Map<Integer, DNode> cache;
    int capacity = 0;
    DNode head;
    DNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DNode(-1, -1);
        tail = new DNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        DNode node = cache.get(key);
        deleteNode(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DNode node = cache.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
        } else {
            DNode node = new DNode(key, value);
            addToHead(node);
            cache.put(key, node);
            if (cache.size() > capacity) {
                removeLast();
            }
        }
    }

    // remove last node.
    private void removeLast() {
        DNode last = tail.pre;
        if (head != last) {
            cache.remove(last.key);
            last.pre.next = tail;
            tail.pre = last.pre;
        }
    }

    private void addToHead(DNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void deleteNode(DNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */