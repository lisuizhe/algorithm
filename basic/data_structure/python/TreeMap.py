class TreeMap:

    def __init__(self, desc=False):
        self.hash = dict()
        self.heap = []
        self.desc = desc

    @property
    def size(self):
        return len(self.heap)

    def firstKey(self):
        if self.size == 0:
            return None
        return self.heap[0]

    def put(self, key, value):
        if key in self.hash:
            self.remove(key)
        self.heap.append(key)
        self.hash[key] = (self.size - 1, value)
        self._shiftUp(self.size - 1)

    def get(self, key):
        if key not in self.hash:
            return None
        _, value = self.hash[key]
        return value

    def getOrDefault(self, key, defaultValue):
        if key not in self.hash:
            return defaultValue
        _, value = self.hash[key]
        return value
    
    def remove(self, key):
        if key not in self.hash:
            return
        index, _ = self.hash[key]
        self._swap(index, self.size - 1)
        del self.hash[key]
        self.heap.pop()

        if index < self.size:
            self._shiftUp(index)
            self._shiftDown(index)

    def _smaller(self, left, right):
        return left < right if not self.desc else right < left

    def _shiftUp(self, index):
        while index != 0:
            parent = (index - 1) // 2
            if self._smaller(self.heap[parent], self.heap[index]):
                break
            self._swap(parent, index)
            index = parent

    def _shiftDown(self, index):
        if index is None:
            return
        while index * 2 + 1 < self.size:
            smallest = index
            left = index * 2 + 1
            right = index * 2 + 2
            if self._smaller(self.heap[left], self.heap[smallest]):
                smallest = left
            if right < self.size and self._smaller(self.heap[right], self.heap[smallest]):
                smallest = right
            if smallest == index:
                break
            self._swap(index, smallest)
            index = smallest

    def _swap(self, i, j):
        keyi = self.heap[i]
        keyj = self.heap[j]
        self.heap[i] = keyj
        self.heap[j] = keyi
        _, valuei = self.hash[keyi]
        _, valuej = self.hash[keyj]
        self.hash[keyi] = (j, valuej)
        self.hash[keyj] = (i, valuei)