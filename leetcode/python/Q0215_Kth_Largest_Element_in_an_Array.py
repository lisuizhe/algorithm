import random
import sys

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if not(nums) or len(nums) < k or k <= 0:
            return sys.maxint 
        self._shuffle(nums)
        return self._findKthLargestElement(nums, k, 0, len(nums) - 1)
    
    def _shuffle(self, nums):
        l = len(nums)
        for i in range(1, len(nums)):
            j = random.randint(0, i - 1)
            nums[i], nums[j] = nums[j], nums[i]

    def _findKthLargestElement(self, nums, k, start, end):
        pivot = nums[end]
        left = start
        for i in range(start, end):
            if nums[i] >= pivot:
                nums[i], nums[left] = nums[left], nums[i]
                left += 1
        nums[left], nums[end] = nums[end], nums[left]
        if k - 1 == left:
            return nums[k - 1]
        elif k - 1 > left:
            return self._findKthLargestElement(nums, k, left + 1, end)
        else:
            return self._findKthLargestElement(nums, k, start, left - 1)
        