class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        results = []
        for digit in digits:
            chars = self._digitToChars(digit)
            previousResults = results
            results = []
            for c in chars:
                if previousResults:
                    for result in previousResults:
                        results.append(result + c)
                else:
                    results.append(c)
        return results

    def _digitToChars(self, digit):
        if digit == '2':
            return ['a', 'b', 'c']
        elif digit == '3':
            return ['d', 'e', 'f']
        elif digit == '4':
            return ['g', 'h', 'i']
        elif digit == '5':
            return ['j', 'k', 'l']
        elif digit == '6':
            return ['m', 'n', 'o']
        elif digit == '7':
            return ['p', 'q', 'r', 's']
        elif digit == '8':
            return ['t', 'u', 'v']
        elif digit == '9':
            return ['w', 'x', 'y', 'z']
        else:
            raise ValueError('Invalid Argument!')

s = Solution()
print(s.letterCombinations('23'))