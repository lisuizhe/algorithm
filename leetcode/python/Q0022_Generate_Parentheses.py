class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        self._backtrack(ans, '', 0, 0, n)
        return ans

    def _backtrack(self, ans, current, left, right, n):
        if left == n and right == n:
            ans.append(current)
            return

        if left < n:
            self._backtrack(ans, current+'(', left+1, right, n)
        if right < left:
            self._backtrack(ans, current+')', left, right+1, n)