import random
import sys

class Solution:
    """
    @param n: An integer
    @param nums: An array
    @return: the Kth largest element
    """
    def kthLargestElement(self, n, nums):
        # write your code here
        if not(nums) or len(nums) < n or n <= 0:
            return sys.maxint 
        self._shuffle(nums)
        return self._findKthLargestElement(nums, n, 0, len(nums) - 1)

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