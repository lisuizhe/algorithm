class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        ans = []
        if not matrix:
            return ans
        r1, r2 = 0, len(matrix) - 1
        c1, c2 = 0, len(matrix[0]) - 1
        while c1 <= c2 and r1 <= r2:
            for c in range(c1, c2 + 1):
                ans.append(matrix[r1][c])
            for r in range(r1 + 1, r2 + 1):
                ans.append(matrix[r][c2])
            if r1 < r2 and c1 < c2:
                for c in range(c2 - 1, c1, -1):
                    ans.append(matrix[r2][c])
                for r in range(r2, r1, -1):
                    ans.append(matrix[r][c1])
            r1 += 1
            r2 -= 1
            c1 += 1
            c2 -= 1
        return ans