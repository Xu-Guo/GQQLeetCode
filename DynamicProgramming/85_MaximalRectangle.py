class Solution(object):

    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        col_num = len(matrix[0])
        hight = [0 for x in range(col_num)]
        left = [0 for x in range(col_num)]
        right = [col_num for x in range(col_num)]
        max_v = 0
        for i in range(len(matrix)):
            for j in range(col_num):
                if matrix[i][j] == "1":
                    hight[j] += 1
                else:
                    hight[j] =0
                
            # calculate left
            curr_left = 0
            for j in range(col_num):
                if matrix[i][j] == "1":
                    left[j] = max(curr_left, left[j])
                else:
                    left[j] = 0
                    curr_left = j + 1

            # calculate right
            curr_right = col_num
            for j in range(col_num-1, -1, -1):
                if matrix[i][j] == "1":
                    right[j] = min(curr_right, right[j])
                else:
                    right[j] = col_num
                    curr_right = j
            
            # max_v = 0
            for j in range(col_num):
                max_v = max((right[j] - left[j]) * hight[j], max_v)

        return max_v
