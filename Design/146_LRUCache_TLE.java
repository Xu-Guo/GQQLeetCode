public class LRUCache {
    private int capacity;
    private LinkedList<Integer> queue;
    private Map<Integer, Integer> cache;
    private Stack<Integer> tmpStack;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.queue = new LinkedList<>();
        this.tmpStack = new Stack<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        updateQueue(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) updateQueue(key);
        else queue.offer(key);
        
        cache.put(key, value);
        if (cache.size() > capacity) {
            // remove least recently used
            Integer removed = queue.poll();
            cache.remove(removed);
        }
        // queue.offer(key);
    }
    
    public void updateQueue(int key) {
        // reorder priority
        tmpStack.clear();
        while (!queue.isEmpty()) {
            int ele = queue.poll();
            if (ele != key) tmpStack.push(ele);
            else {
                queue.offer(key);
                break;
            }
        }
        
        // System.out.println(queue.stream().map(Object::toString).collect(Collectors.joining(", ")));
        while(!tmpStack.isEmpty()) {
            queue.add(0, tmpStack.pop());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */