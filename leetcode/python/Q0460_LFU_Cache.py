from collections import OrderedDict

class MyValue:
    def __init__(self, value, frequency):
        self.value, self.frequency = value, frequency

class LFUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.minFreq = 0
        self.myValues = {}
        self.freqToKey = { 1: OrderedDict() }

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.myValues:
            myValue = self.myValues[key]
            del self.freqToKey[myValue.frequency][key]
            if self.minFreq == myValue.frequency and len(self.freqToKey[self.minFreq]) == 0:
                self.minFreq += 1
            myValue.frequency += 1
            self.myValues[key] = myValue
            if not (myValue.frequency) in self.freqToKey:
                self.freqToKey[myValue.frequency] = OrderedDict()
            self.freqToKey[myValue.frequency][key] = key
            return myValue.value
        else:
            return -1

            
    def _evict(self):
        if len(self.myValues) > 0:
            evictKey, tmp = self.freqToKey[self.minFreq].popitem(last=False)
            del self.myValues[evictKey]

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if self.capacity <= 0:
            return
        if key in self.myValues:
            myValue = self.myValues[key]
            myValue.value = value
            self.myValues[key] = myValue
            self.get(key)
            return
        if len(self.myValues) >= self.capacity:
            self._evict()
        self.minFreq = 1
        myValue = MyValue(value, 1)
        self.myValues[key] = myValue
        self.freqToKey[1][key] = key


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)