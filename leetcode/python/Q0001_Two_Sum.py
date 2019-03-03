class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        complementToIndex = {}
        for index, item in enumerate(nums):
            if item in complementToIndex:
                return [complementToIndex[item], index]
            complementToIndex[target - item] = index
            
        return []

solution = Solution()
print(solution.twoSum([1,2,3,4,5],4))