from collections import OrderedDict

class MyValue:
    def __init__(self, value, frequency):
        self.value, self.frequency = value, frequency

class LFUCache:
    """
    @param: capacity: An integer
    """
    def __init__(self, capacity):
        # do intialization if necessary
        self.capacity = capacity
        self.minFreq = 0
        self.myValues = {}
        self.freqToKey = { 1: OrderedDict() }

    """
    @param: key: An integer
    @param: value: An integer
    @return: nothing
    """
    def set(self, key, value):
        # write your code here
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
            
    def _evict(self):
        if len(self.myValues) > 0:
            evictKey, tmp = self.freqToKey[self.minFreq].popitem(last=False)
            del self.myValues[evictKey]

    """
    @param: key: An integer
    @return: An integer
    """
    def get(self, key):
        # write your code here
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