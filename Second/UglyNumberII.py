class Solution(object):

    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        idx = [0, 0, 0]
        ret = [0] * n
        ret[0] = 1
        for i in range(1, n):
            ret[i] = min(2 * ret[idx[0]], 3 * ret[idx[1]], 5 * ret[idx[2]])
            if ret[i] == 2 * ret[idx[0]]:
                idx[0] += 1
            if ret[i] == 3 * ret[idx[1]]:
                idx[1] += 1
            if ret[i] == 5 * ret[idx[2]]:
                idx[2] += 1
        return ret[n - 1]
