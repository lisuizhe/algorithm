package Q0134_LRU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LRUCache {
    
    private int capacity;
    private Map<Integer, Integer> cache;
    private LinkedHashSet<Integer> keys;
    
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keys = new LinkedHashSet<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (this.cache.containsKey(key)) {
            this.keys.remove(key);
            this.keys.add(key);
            return this.cache.get(key);
        } else {
            return -1;
        }
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
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