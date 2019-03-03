class HashHeap:

    def __init__(self, desc=False):
        self.hash = dict()
        self.heap = []
        self.desc = desc

    @property
    def size(self):
        return len(self.heap)

    def top(self):
        if self.size == 0:
            return None
        return self.heap[0]

    def push(self, item):
        if item in self.hash:
            self.remove(item)
        self.heap.append(item)
        self.hash[item] = self.size - 1
        self._shiftUp(self.size - 1)

    def pop(self):
        if self.size == 0:
            return None
        item = self.heap[0]
        self.remove(item)
        return item
    
    def remove(self, item):
        if item not in self.hash:
            return
        index = self.hash[item]
        self._swap(index, self.size - 1)
        del self.hash[item]
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
        itemi = self.heap[i]
        itemj = self.heap[j]
        self.heap[i] = itemj
        self.heap[j] = itemi
        self.hash[itemi] = j
        self.hash[itemj] = i