import heapq

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

class BuildingEdge:

    def __init__(self, x, height, isLeft):
        self.x = x
        self.height = height
        self.isLeft = isLeft
    
    def __lt__(self, o):
        if self.x != o.x:
            return self.x < o.x
        else:
            if self.isLeft:
                if o.isLeft:
                    return self.height > o.height
                else:
                    return True
            else:
                if o.isLeft:
                    return False
                else:
                    return self.height < o.height

    def __repr__(self):
        return 'BuildingEdge{x:' + str(self.x) + ',height:' + str(self.height) + ',isLeft:' + str(self.isLeft) + '}'

class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        events = sorted([(L, -H, R) for L, R, H in buildings] + list({(R, 0, None) for _, R, _ in buildings}))
        res, hp = [[0, 0]], [(0, float("inf"))]
        for x, negH, R in events:
            while x >= hp[0][1]: 
                heapq.heappop(hp)
            if negH: 
                heapq.heappush(hp, (negH, R))
            if res[-1][1] + hp[0][0]: 
                res += [x, -hp[0][0]],
        return res[1:]

    def _getSkylineByTreeMap(self, buildings):
        results = []
        if not buildings:
            return results
        
        edges = []
        for building in buildings:
            edges.append(BuildingEdge(building[0], building[2], True))
            edges.append(BuildingEdge(building[1], building[2], False))
        edges = sorted(edges)

        heightToCount = TreeMap(desc=True)
        sizeOfEdges = len(edges)
        prevHeight = None
        for i in range(sizeOfEdges):
            edge = edges[i]
            if edge.isLeft:
                heightToCount.put(edge.height, heightToCount.getOrDefault(edge.height, 0)+1)
                currentHeight = heightToCount.firstKey()
                if currentHeight != prevHeight:
                    results.append([edge.x, currentHeight])
                    prevHeight = currentHeight
            else:
                count = heightToCount.get(edge.height)
                if count > 1:
                    heightToCount.put(edge.height, count-1)
                else:
                    heightToCount.remove(edge.height)
                if heightToCount.size == 0:
                    if prevHeight != 0:
                        results.append([edge.x, 0])
                        prevHeight = 0
                else:
                    currentHeight = heightToCount.firstKey()
                    if currentHeight != prevHeight:
                        results.append([edge.x, currentHeight])
                        prevHeight = currentHeight

        return results

#buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
#buildings = [[0,2,3],[2,5,3]]
#buildings = [[0,2,3],[2,4,3],[4,6,3]]
buildings = [[0,5,7],[5,10,7],[5,10,12],[10,15,7],[15,20,7],[15,20,12],[20,25,7]]
solution = Solution()
print(solution.getSkyline(buildings))