package Q0109_Triangle;

class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int height = triangle.length;
        int[] minSum = triangle[height - 1];
        for (int layer = height - 2; layer >= 0; layer--) {
            for (int i = 0; i < layer + 1; i++) {
                minSum[i] = Math.min(minSum[i], minSum[i + 1]) + triangle[layer][i];
            }
        }
        return minSum[0];
    }
}