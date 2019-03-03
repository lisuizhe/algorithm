class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        numSet = set(nums)
        maxLength = 0
        for num in numSet:
            if (num - 1) not in numSet:
                currentNum = num
                currentLength = 1
                while (currentNum + 1) in numSet:
                    currentLength += 1
                    currentNum += 1
                maxLength = max(maxLength, currentLength)
        return maxLength