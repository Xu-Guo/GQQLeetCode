class Solution(object):

    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        lengh = len(triangle)
        if lengh == 0:
            return 0
        lst_res = []
        for row in triangle:
            lst_res.append(min_val(row))
        return sum(lst_res)

    def min_val(row):
        min_v = row[0]
        for i in range(1, len(row)):
            if row[i] < min_v:
                min_v = row[i]
        return min_v
