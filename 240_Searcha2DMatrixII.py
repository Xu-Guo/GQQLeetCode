class Solution(object):

    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        int low1, high1, low2, high2 = 0, 0, m - 1, n - 1
        while low1 < high1 and low2 < high2:
            mid1 = low1 + (high1 - low1) / 2
            mid2 = low2 + (high2 - low2) / 2
            val = matrix[mid1][mid2]
            if val == target:
                return True
            else val > target:
                

