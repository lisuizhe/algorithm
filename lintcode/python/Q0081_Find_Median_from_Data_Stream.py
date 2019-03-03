from heapq import *

class Solution:
    """
    @param nums: A list of integers
    @return: the median of numbers
    """
    def medianII(self, nums):
        # write your code here
        self.small = []
        self.large = []
        result = []
        for num in nums:
            self.addNum(num)
            result.append(self.findMedian())
        return result

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        heappush(self.small, -heappushpop(self.large, num))
        if len(self.large) < len(self.small):
            heappush(self.large, -heappop(self.small))
            
    def findMedian(self):
        """
        :rtype: float
        """
        if len(self.large) > len(self.small):
            return self.large[0]
        else:
            return -self.small[0]