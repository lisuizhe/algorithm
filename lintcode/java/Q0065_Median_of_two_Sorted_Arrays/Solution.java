package Q0065_Median_of_two_Sorted_Arrays;

class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0) {
            return ((double)(B[(B.length-1)/2] + B[B.length/2])) / 2;
        } else if (B == null || B.length == 0) {
            return ((double)(A[(A.length-1)/2] + A[A.length/2])) / 2;
        }
        int N1 = A.length;
        int N2 = B.length;
        if (N1 < N2) {
            return findMedianSortedArrays(B, A);
        }
        
        int lo = 0;
        int hi = N2 * 2;
        while (lo <= hi) {
            int mid2 = (lo + hi) / 2;
            int mid1 = N1 + N2 - mid2;
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : A[(mid1-1)/2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : B[(mid2-1)/2];
            double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : A[mid1/2];
            double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : B[mid2/2];
            
            if (L1 > R2) {
                lo = mid2 + 1;
            } else if (L2 > R1) {
                hi = mid2 -1;
            } else {
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            }
        }
        return -1;
    }
}