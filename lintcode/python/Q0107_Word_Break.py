class Solution:
    """
    @param: s: A string
    @param: dict: A dictionary of words dict
    @return: A boolean
    """
    def wordBreak(self, s, dict):
        # write your code here
        l = len(s)
        if len(dict) == 0:
            return l == 0
        maxLength = max([len(w) for w in dict])
        canBreakSubstring = [False] * (l + 1)
        canBreakSubstring[0] = True
        for end in range(1, l + 1):
            for start in range(end - 1, max(0, end - maxLength) -1, -1):
                if not canBreakSubstring[start]:
                    continue
                if s[start:end] in dict:
                    canBreakSubstring[end] = True
                    break
        return canBreakSubstring[l]