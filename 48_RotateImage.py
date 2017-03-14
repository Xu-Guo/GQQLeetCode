class Solution(object):

    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if not matrix:
            return
        m = len(matrix)
        if m == 0 or m == 1:
            return
        for i in range(m / 2 + 1):
            for j in range(i, m - i - 1):
                tmp = matrix[i][j]
                matrix[i][j] = matrix[m - 1 - j][i]
                matrix[m - 1 - j][i] = matrix[m - 1 - i][m - 1 - j]
                matrix[m - 1 - i][m - 1 - j] = matrix[j][m - 1 - i]
                matrix[j][m - 1 - i] = tmp
