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
        return self.doSearch(low1, high1, low2, high2, matrix, m, n)

    def doSearch(self, low1, high1, low2, high2, matrix, m, n):
        if low1 < 0 or high1 >= m or low1 > high1:
            return False
        if low2 < 0 or high2 >= n or low2 > high2:
            return False
        if low1 == high1 and low2 == high2:
            return True matrix[low1][low2] == target else False
        elif low1 == high1:
            while low2 <= high2:
                mid = low2 + (high2 - low2) / 2
                if target == matrix[low1][mid]:
                    return True
                elif target < matrix[low1][mid]:
                    low2 = mid + 1
                else:
                    high2 = mid - 1
            return False
        elif low2 == high2:
            while low1 <= high1:
                mid = low1 + (high1 - low1) / 2
                if target == matrix[mid][low2]:
                    return True
                elif target < matrix[mid][low2]:
                    low1 = mid + 1
                else:
                    high1 = mid - 1
            return False
        mid1 = low1 + (high1 - low1) / 2
        mid2 = low2 + (high2 - low2) / 2
        if matrix[mid1][mid2] == target:
            return True
        elif matrix[mid1][mid2] < target:
            test1 = self.doSearch(mid1 + 1, high1, low2, mid2)
            test2 = self.doSearch(low1, mid1, mid2 + 1, high2)
            test3 = self.doSearch(mid1 + 1, high1, mid2 + 1, high2)
            return test1 or test2 or test3
        else:
            test1 = self.doSearch(mid1, high1, low2, mid2 - 1)
            test2 = self.doSearch(low1, mid1 - 1, mid2, high2)
            test3 = self.doSearch(low1, mid1 - 1, low2, mid2 - 1)
            return test1 or test2 or test3
