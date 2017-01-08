class Solution(object):

    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        lines = len(matrix)
        cols = len(matrix[0])
        res = []
        for i in range(lines):
            line = []
            for j in range(cols):
                line.append(CellInfo())
            res.append(line)
        if matrix[0][0] == "1":
            res[0][0].set_horizons(1, 1)
            res[0][0].set_verticals(1, 1)
            res[0][0].set_rects(1, 1)

        # init first coloum
        for i in range(1, lines):
            if matrix[i][0] == "1":
                res[i][0].set_horizons(1, 1)
                res[i][0].set_verticals(1, res[i - 1][0].verticals[1] + 1)
                res[i][0].set_rects(1, 1)
        # init first line
        for j in range(1, cols):
            if matrix[0][j] == "1":
                res[0][j].set_horizons(res[0][j - 1].horizons[0] + 1, 1)
                res[0][j].set_verticals(1, 1)
                res[0][j].set_rects(1, 1)
        # print res[0][0].verticals[1]
        # print res[0][1].verticals[1]
        # print res[1][0].verticals[1]
        # calculate whole result map.
        for i in range(1, lines):
            for j in range(1, cols):
                if matrix[i][j] == "1":
                    res[i][j].set_horizons(res[i][j - 1].horizons[0] + 1, 1)
                    res[i][j].set_verticals(1, res[i - 1][j].verticals[1] + 1)
                    # print res[i - 1][j].verticals[1], res[i - 1][j - 1].verticals[1]
                    max_x = min(res[i][j - 1].horizons[0], res[i - 1][j - 1].horizons[0]) + 1
                    max_y = min(res[i - 1][j].verticals[1], res[i - 1][j - 1].verticals[1]) + 1
                    # print i, j, max_x, max_y
                    res[i][j].set_rects(max_x, max_y)

        # get the maximal value
        max_value = 0
        for i in range(0, lines):
            for j in range(0, cols):
                max_value = max(max_value, res[i][j].horizons[0] * 1, 1 * res[i][j].verticals[1], res[i][j].rects[0] * res[i][j].rects[1])
        return max_value


class CellInfo(object):
    """docstring for CellInfo"""

    def __init__(self):
        super(CellInfo, self).__init__()
        self.horizons = [0, 0]
        self.verticals = [0, 0]
        self.rects = [0, 0]

    def set_horizons(self, l, r):
        self.horizons[0] = l
        self.horizons[1] = r

    def set_verticals(self, l, r):
        self.verticals[0] = l
        self.verticals[1] = r

    def set_rects(self, l, r):
        self.rects[0] = l
        self.rects[1] = r

if __name__ == '__main__':
    s = Solution()
    print s.maximalRectangle(["11","11"])