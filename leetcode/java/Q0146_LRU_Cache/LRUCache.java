package Q0146_LRU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LRUCache {

    private int capacity;
    private Map<Integer, Integer> cache;
    private LinkedHashSet<Integer> keys;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keys = new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)) {
            this.keys.remove(key);
            this.keys.add(key);
            return this.cache.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.cache.remove(key);
            this.keys.remove(key);
        } else if (this.cache.size() >= this.capacity) {
            this.evict();
        }
        this.cache.put(key, value);
        this.keys.add(key);
    }
    
    private void evict() {
        if (this.cache.size() > 0) {
            int evictKey = this.keys.iterator().next();
            this.keys.remove(evictKey);
            this.cache.remove(evictKey);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */