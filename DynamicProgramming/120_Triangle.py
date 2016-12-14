class Solution(object):

    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        t = triangle
        if len(t) == 1:
            return t[0][0]
        ret = [0] * len(t)
        ret[0] = t[0][0]
        for i in range(1, len(t)):
            for j in range(0, i + 1):
                if j == 0:
                    old_v = ret[j]
                    ret[j] += t[i][j]
                elif j == i:
                    ret[j] = old_v + t[i][j]
                else:
                    val = min(old_v + t[i][j], ret[j] + t[i][j])
                    old_v = ret[j]
                    ret[j] = val
        return min(ret)
