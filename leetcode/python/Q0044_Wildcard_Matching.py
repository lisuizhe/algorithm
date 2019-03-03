class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        sIndex, pIndex, matchIndex, asteriskIndex = 0, 0, 0, -1
        while sIndex < len(s):
            if pIndex < len(p) and (s[sIndex] == p[pIndex] or p[pIndex] == '?'):
                sIndex += 1
                pIndex += 1
            elif pIndex < len(p) and p[pIndex] == '*':
                asteriskIndex = pIndex
                matchIndex = sIndex
                pIndex += 1
            elif asteriskIndex != -1:
                pIndex = asteriskIndex + 1
                matchIndex += 1
                sIndex = matchIndex
            else:
                return False
        while pIndex < len(p) and p[pIndex] == '*':
            pIndex += 1
        return pIndex == len(p)
