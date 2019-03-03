class Solution:
    """
    @param A: An integers array.
    @return: return any of peek positions.
    """
    def findPeak(self, A):
        # write your code here
        left, right = 0, len(A) - 1
        while left < right:
            mid = (left + right) / 2
            if A[mid] > A[mid+1]:
                right = mid
            else:
                left = mid + 1
        return left