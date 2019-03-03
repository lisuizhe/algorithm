class Solution:
    """
    @param: s: A string
    @param: wordDict: A set of words.
    @return: All possible sentences.
    """
    def wordBreak(self, s, wordDict):
        # write your code here
        return self._recursiveWordBreak(s, wordDict, {})
        
    def _recursiveWordBreak(self, s, wordDict, memo):
        if s in memo: 
            return memo[s]
        if not s: 
            return []
        
        res = []
        for word in wordDict:
            if not word or not s.startswith(word):
                continue
            if len(word) == len(s):
                res.append(word)
            else:
                resultOfTheRest = self._recursiveWordBreak(s[len(word):], wordDict, memo)
                for item in resultOfTheRest:
                    item = word + ' ' + item
                    res.append(item)
        memo[s] = res
        return res