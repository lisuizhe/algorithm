class LRUNode:
    
    def __init__(self, key, value):
        self.key, self.value = key, value
        self.prev, self.next = None, None

class LRUCache:
    """
    @param: capacity: An integer
    """
    def __init__(self, capacity):
        # do intialization if necessary
        self.capacity = capacity
        self.cache = {}
        self.head = LRUNode(-1, -1)
        self.tail = LRUNode(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        
    """
    @param: key: An integer
    @return: An integer
    """
    def get(self, key):
        # write your code here
        if key in self.cache:
            node = self.cache[key]
            self._remove(node)
            self._add(node)
            return node.value
        return -1
            
    def _remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
        del self.cache[node.key]
        
    def _add(self, node):
        self.cache[node.key] = node
        self.tail.prev.next = node
        node.prev = self.tail.prev
        node.next = self.tail
        self.tail.prev = node

    """
    @param: key: An integer
    @param: value: An integer
    @return: nothing
    """
    def set(self, key, value):
        # write your code here
        if key in self.cache:
            self._remove(self.cache[key])
        node = LRUNode(key, value)
        self._add(node)
        if len(self.cache) > self.capacity:
            self._remove(self.head.next)
