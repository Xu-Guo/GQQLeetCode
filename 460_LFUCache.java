class DNode {
    int key;
    int val;
    // frequency.
    int freq;
    DNode pre;
    DNode next;
    public DNode(int key, int val) {
        this.key = key;
        this.val = val;
        freq = 1;
    }
}
public class LFUCache {
    Map<Integer, DNode> cache;
    int capacity = 0;
    DNode head;
    DNode tail;
    Map<Integer, DNode> fmap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DNode(-1, -1);
        tail = new DNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        fmap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        DNode node = cache.get(key);
        ++node.freq;
        deleteNode(node);
        // addToHead(node);
        updateMap(node);
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

    private void insertNewNode(DNode node) {
        if (fmap.containsKey(1)) {
            // if contains 1, insert before 1
            DNode ori = fmap.get(1);
            // insert node before ori
            insertAhead(node, ori);
            fmap.put(1, node);
        }
    }
    
    private void updateMap(DNode node) {
        // ++node.freq;
        if (fmap.containsKey(node.freq)) {
            DNode dn = fmap.get(node.freq);
            dn.pre.next = node;
            node.next = dn;
            node.pre = dn.pre;
            dn.pre = node;
            fmap.put(node.freq, node);
        } else {
           fmap.put(node.freq, node);
           addToHead(node);
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