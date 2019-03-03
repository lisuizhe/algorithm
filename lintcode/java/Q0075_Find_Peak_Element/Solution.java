package Q0075_Find_Peak_Element;

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] > A[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}