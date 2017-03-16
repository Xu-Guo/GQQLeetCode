public class LRUCache {
    Map<Integer, Integer> cache;
    Map<Integer, Integer> keyToPro;
    Map<Integer, Integer> proToKey;
    int min = 0, max = 0;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        keyToPro = new HashMap<>();
        proToKey = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        updatePriority(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
        // get previous priority
        updatePriority(key);
        if (cache.size() > capacity) {
            Integer removed = proToKey.get(min);
            cache.remove(removed);
            keyToPro.remove(removed);
            proToKey.remove(min);
            updatemin();
        }
    }

    public void updatePriority(int key) {
        Integer prepro = keyToPro.get(key);
        keyToPro.put(key, ++max);
        if (prepro != null) proToKey.remove(prepro);
        proToKey.put(max, key);
        updatemin();
    }

    public void updatemin() {
        if (min <= max && !proToKey.containsKey(min)) min++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */