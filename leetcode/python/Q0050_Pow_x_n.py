class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        ans = 1
        absN = n if n > 0 else -n
        while absN > 0:
            if absN & 1 == 1:
                ans *= x
            absN >>= 1
            x *= x
        return ans if n > 0 else 1/ans