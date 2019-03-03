class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return -1
        unique = dict()
        for i in range(len(s)):
            if s[i] in unique:
                unique[s[i]] = False
            else:
                unique[s[i]] = True
        for i in range(len(s)):
            if unique[s[i]]:
                return i
        return -1