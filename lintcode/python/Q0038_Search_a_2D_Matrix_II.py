class Solution:
    """
    @param matrix: A list of lists of integers
    @param target: An integer you want to search in matrix
    @return: An integer indicate the total occurrence of target in the given matrix
    """
    def searchMatrix(self, matrix, target):
        # write your code here
        count = 0
        if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0:
            return count
        row = 0;
        column = len(matrix[0]) - 1;
        while row < len(matrix) and column >= 0:
            if matrix[row][column] == target:
                count += 1
                row += 1
            elif matrix[row][column] < target:
                row += 1
            else:
                column -= 1
        return count;