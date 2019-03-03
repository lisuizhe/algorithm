class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s is None:
            return False
        if len(s) == 0:
            return True
        stack = []
        for i in range(len(s)):
            c = s[i]
            if self._isLeftParentheses(c):
                stack.append(c)
            elif self._isRightParentheses(c):
                if not stack:
                    return False
                elif not self._isPairParentheses(stack.pop(), c):
                    return False
        if stack:
            return False
        else:
            return True
        
    def _isLeftParentheses(self, c):
        return (c == '(') or (c == '{') or (c == '[')

    def _isRightParentheses(self, c):
        return (c == ')') or (c == '}') or (c == ']')
    
    def _isPairParentheses(self, c1, c2):
        if c1 == '(':
            return c2 == ')'
        if c1 == '{':
            return c2 == '}'
        if c1 == '[':
            return c2 == ']'
        return False

s = Solution()
print(s.isValid("()"))