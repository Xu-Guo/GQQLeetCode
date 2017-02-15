class Solution(object):

    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if len(matrix) == 0:
            return 0
        longest = 1
        dic = {}
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                longest = max(longest, self.getLongest(matrix, i, j, -2147483648, dic))
        # test = self.getLongest(matrix, 0, 0, -2147483648, dic)
        return longest


    def getLongest(self, matrix, i, j, curr, dic):
        if i < 0 or i >= len(matrix) or j < 0 or j >= len(matrix[0]):
            # print "ii"
            return 0
        if matrix[i][j] <= curr:
            return 0
        key = str(i*len(matrix[0])+j)
        if dic.has_key(key):
            return dic.get(key)
        top = 1 + self.getLongest(matrix, i - 1, j, matrix[i][j],dic)
        left = 1 + self.getLongest(matrix, i, j-1, matrix[i][j],dic)
        bottom = 1 + self.getLongest(matrix, i+1, j, matrix[i][j],dic)
        right = 1 + self.getLongest(matrix, i, j+1, matrix[i][j],dic)
        # print top,left,bottom,right
        longest = max(top, left, bottom, right)

        dic[key] = longest
        return longest