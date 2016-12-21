import math
class Solution(object):

    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        ret = [0] * (n+1)
        ret[1] = 1
        for x in range(2, n+1):
            end = int(math.sqrt(x))
            if x == end**2:
                ret[x] = 1
            else:
                min_v = 1 + ret[x-1]
                for i in range(2, end+1):
                    v = ret[i**2] + ret[x - i**2]
                    min_v = v if v<min_v else min_v
                ret[x] = min_v
        return ret[-1]