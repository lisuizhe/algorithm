class Solution:
    """
    @param s: A string
    @param k: An integer
    @return: An integer
    """
    def lengthOfLongestSubstringKDistinct(self, s, k):
        # write your code here
        charCount = {}
        maxLength = 0
        start = 0
        end = 0
        count = 0
        while end < len(s):
            c = s[end]
            if c in charCount:
                charCount[c] = charCount[c] + 1
            else:
                charCount[c] = 1
            if charCount[c] == 1:
                count += 1
            end += 1
            while count > k:
                ch = s[start]
                charCount[ch] = charCount[ch] - 1
                if charCount[ch] == 0:
                    count -= 1
                start += 1
            maxLength = max(maxLength, end - start)
        return maxLength

s = Solution()
print(s.lengthOfLongestSubstringKDistinct("eceba", 3))