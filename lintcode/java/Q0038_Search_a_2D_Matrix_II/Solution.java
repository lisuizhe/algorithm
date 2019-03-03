package Q0038_Search_a_2D_Matrix_II;

class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int count = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return count;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (column >= 0 && row < matrix.length) {
            if (matrix[row][column] == target) {
                count++;
                row++;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return count;
    }
}