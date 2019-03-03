from heapq import heappop, heappush

class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        heap = []
        n = len(matrix[0])
        for i in range(n):
            heappush(heap, (matrix[0][i], 0, i))
        for i in range(k-1):
            element = heappop(heap)
            if element[1] == (n-1):
                continue
            else:
                heappush(heap, (matrix[element[1]+1][element[2]], element[1]+1, element[2]))
        return heappop(heap)[0]