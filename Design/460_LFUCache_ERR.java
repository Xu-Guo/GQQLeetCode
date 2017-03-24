public class LFUCache {
    Map<Integer, Integer> key_values = new HashMap<>();
    Map<Integer, FreqNode> key_nodes = new HashMap<>();
    // head of frequency list.
    FreqNode head;
    // tail of frequency list.
    FreqNode tail;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = new FreqNode(-1);
        tail = new FreqNode(-1);
        head.next = tail;
        tail.next = head;
    }
    
    public int get(int key) {
        if (!key_values.containsKey(key)) return -1;
        increaseKeyFrequency(key);
        return key_values.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (key_values.containsKey(key)) {
            key_values.put(key, value);
            // increase frequency of current key.
            increaseKeyFrequency(key);
        } else {
            // fi capacity is full, delete the least frequency and earliest one
            // frequency list ensure frequency and LinkedHashSet ensure earlisest.
            if (key_values.size() == capacity) {
                int deleted = removeOldest();
                // System.out.println(key+" "+deleted);
                key_values.remove(deleted);
            }
            key_values.put(key, value);
            addTohead(key);
        }
    }

    public void deleteNode(FreqNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void insertNodeAfter(FreqNode front, FreqNode after) {
        after.next = front.next;
        front.next.pre = front;
        after.pre = front;
        front.next = after;
    }

    public void increaseKeyFrequency(int key) {
        FreqNode node = key_nodes.get(key);
        key_nodes.remove(key);
        node.sameFreqKeys.remove(key);
        // System.out.println("increase " + key +" "+node.frequency+ " ->" + node.next.frequency);
        if (node.next.frequency == node.frequency + 1) {
            node.next.sameFreqKeys.add(key);
            // System.out.println("new same keys "+ node.next.sameFreqKeys);
            key_nodes.put(key, node.next);
        } else {
            FreqNode newFreqNode = new FreqNode(node.frequency + 1);
            // newFreqNode.next = node.next;
            newFreqNode.sameFreqKeys.add(key);
            insertNodeAfter(node, newFreqNode);
            key_nodes.put(key, newFreqNode);
        }
        if (node.sameFreqKeys.size() == 0) {
            deleteNode(node);
        }
    }

    public int removeOldest() {
        if (head.next == tail) return -1;
        FreqNode node = head.next;
        // System.out.println(node.sameFreqKeys + " " + node.frequency);
        int deletedKey = node.sameFreqKeys.iterator().next();
        
        node.sameFreqKeys.remove(deletedKey);
        if (node.sameFreqKeys.size() == 0) deleteNode(node);
        key_nodes.remove(deletedKey);
        return deletedKey;
    }


    public void addTohead(Integer key) {
        // 0 frequency node exists.
        if (head.next.frequency == 0) {
            head.next.sameFreqKeys.add(key);
            key_nodes.put(key, head.next);
        } else {
            // we need to create a 0 frequency node.
            FreqNode node = new FreqNode(0);
            node.sameFreqKeys.add(key);
            // insert node after head
            insertNodeAfter(head, node);
            key_nodes.put(key, node);
        }
    }
}

class FreqNode {
    public FreqNode(int frequency) {
        this.frequency = frequency;
        sameFreqKeys = new LinkedHashSet<>();
    }
    LinkedHashSet<Integer> sameFreqKeys;
    FreqNode pre;
    FreqNode next;
    int frequency;
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */