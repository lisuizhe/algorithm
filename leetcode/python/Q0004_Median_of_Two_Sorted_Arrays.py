class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        A, B = nums1, nums2
        N1, N2 = len(A), len(B)
        if N1 < N2:
            return self.findMedianSortedArrays(B, A)
            
        lo, hi = 0, N2 * 2
        import sys
        while lo <= hi:
            mid2 = (lo + hi) / 2
            mid1 = N1 + N2 - mid2
            L1 = float((-sys.maxint-1) if (mid1 == 0) else A[(mid1-1)/2])
            L2 = float((-sys.maxint-1) if (mid2 == 0) else B[(mid2-1)/2])
            R1 = float(sys.maxint if (mid1 == N1 * 2) else A[mid1/2])
            R2 = float(sys.maxint if (mid2 == N2 * 2) else B[mid2/2])
            
            if L1 > R2:
                lo = mid2 + 1
            elif L2 > R1:
                hi = mid2 - 1
            else:
                return (max(L1, L2) + min(R1, R2)) / 2
        return -1
        