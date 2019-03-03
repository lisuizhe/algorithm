class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #sum + move * (n-1) = n  * (min + move) -> move = sum - n * min
        return sum(nums) - len(nums) * min(nums)
        