class Solution:
    """
    @param nums: an array
    @return: the minimum number of moves required to make all array elements equal
    """
    def minMoves(self, nums):
        # Write your code here
        #sum + move * (n-1) = n * (min + move) -> move = sum - n * min
        return sum(nums) - len(nums) * min(nums)