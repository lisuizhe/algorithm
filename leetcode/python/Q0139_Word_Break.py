class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        if len(wordDict) == 0:
            return len(s) == 0
        l = len(s)
        maxLength = max([len(w) for w in wordDict])
        canBreakSubstring = [False] * (l + 1)
        canBreakSubstring[0] = True
        for end in range(1, l + 1):
            for start in range(end - 1, max(0, end - maxLength) -1, -1):
                if canBreakSubstring[start] and s[start:end] in wordDict:
                    canBreakSubstring[end] = True
                    break
        return canBreakSubstring[l]