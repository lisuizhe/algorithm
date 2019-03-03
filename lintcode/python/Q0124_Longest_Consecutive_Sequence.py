class Solution:
    """
    @param num: A list of integers
    @return: An integer
    """
    def longestConsecutive(self, num):
        # write your code here
        numSet = set(num)
        maxLength = 0
        for i in numSet:
            if (i - 1) not in numSet:
                currentNum = i
                currentLength = 1
                while (currentNum + 1) in numSet:
                    currentLength += 1
                    currentNum += 1
                maxLength = max(maxLength, currentLength)
        return maxLength
