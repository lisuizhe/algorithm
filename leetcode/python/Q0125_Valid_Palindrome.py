class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        target = ''
        ordA = ord('A')
        ordZ = ord('Z')
        orda = ord('a')
        for c in s:
            if not c.isalnum():
                continue
            ordC = ord(c)
            if ordC >= ordA and ordC <= ordZ:
                c = chr(ordC - ordA + orda)
            target += c
        left = 0
        right = len(target) - 1
        while left <= right:
            if target[left] != target[right]:
                return False
            left += 1
            right -= 1
        return True

s = Solution()
print(s.isPalindrome("A man, a plan, a canal: Panama"))
            