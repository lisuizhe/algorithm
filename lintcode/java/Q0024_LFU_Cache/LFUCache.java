package Q0024_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    static class MyValue {
        int value;
        int frequency;

        MyValue(int value, int frequency){
            this.value = value;
            this.frequency = frequency;
        }
    }
    
    Map<Integer, MyValue> myValues;
    Map<Integer, LinkedHashSet<Integer>> freqToKey;
    int capacity;
    int minFreq;
    
    /*
    * @param capacity: An integer
    */public LFUCache(int capacity) {
        // do intialization if necessary
        this.myValues = new HashMap<>();
        this.freqToKey = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
        this.freqToKey.put(1, new LinkedHashSet<>());
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (this.capacity <= 0) {
            return;
        }
        if (this.myValues.containsKey(key)) {
            MyValue myValue = this.myValues.get(key);
            myValue.value = value;
            this.myValues.put(key, myValue);
            this.get(key);
            return;
        }
        if (this.myValues.size() >= this.capacity) {
            int evitKey = this.freqToKey.get(this.minFreq).iterator().next();
            this.freqToKey.get(this.minFreq).remove(evitKey);
            this.myValues.remove(evitKey);
        }
        MyValue myValue = new MyValue(value, 1);
        this.myValues.put(key, myValue);
        this.minFreq = 1;
        this.freqToKey.get(1).add(key);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (this.myValues.containsKey(key)) {
            MyValue myValue = this.myValues.get(key);
            int frequency = myValue.frequency;
            myValue.frequency = frequency + 1;
            this.myValues.put(key, myValue);
            this.freqToKey.get(frequency).remove(key);
            if (frequency == minFreq && freqToKey.get(frequency).size() == 0) {
                this.minFreq++;
            }
            if (!this.freqToKey.containsKey(frequency + 1)) {
                this.freqToKey.put(frequency + 1, new LinkedHashSet<>());
            }
            this.freqToKey.get(frequency + 1).add(key);
            return myValue.value;
        } else {
            return -1;
        }
    }
}