from collections import deque

class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums or k <= 0:
            return nums

        dq = deque([])
        for i in range(k-1, -1, -1):
            if not dq or dq[0] < nums[i]:
                dq.appendleft(nums[i])

        results = []
        results.append(dq[0])
        for i in range(1, len(nums)-k+1):
            if nums[i-1] == results[i-1]:
                dq.popleft()
            while dq and dq[-1] < nums[i+k-1]:
                dq.pop()
            dq.append(nums[i+k-1])
            results.append(dq[0])
        return results
