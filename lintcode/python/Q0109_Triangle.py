class Solution:
    """
    @param triangle: a list of lists of integers
    @return: An integer, minimum path sum
    """
    def minimumTotal(self, triangle):
        # write your code here
        height = len(triangle)
        minSum = triangle[height - 1]
        for layer in range(height - 2, -1, -1):
            for i in range(0, layer + 1):
                minSum[i] = min(minSum[i], minSum[i + 1]) + triangle[layer][i]
        return minSum[0]