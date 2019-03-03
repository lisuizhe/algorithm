class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        nums.insert(0, 1)
        nums.append(1)
        memo = dict()
        def burst(left, right):
            if left + 1 >= right:
                return 0
            if (left, right) in memo:
                return memo[(left, right)]
            coins = 0
            for i in range(left+1, right):
                coins = max(coins, nums[left] * nums[i] * nums[right]
                            + burst(left, i) + burst(i, right))
            memo[(left, right)] = coins
            return coins
        return burst(0, len(nums)-1)
        