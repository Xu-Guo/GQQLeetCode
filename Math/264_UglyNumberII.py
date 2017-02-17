class Solution(object):

    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = [x for x in range(6)]
        if n in res:
            return n
        pos = [3, 3, 5]
        start = 6
        while start <= n:
            m2 = 2 * res[pos[0]]
            m3 = 3 * res[pos[1]]
            m5 = 5 * res[pos[2]]
            if m2 <= m3 and m2 <= m5:
                res.append(m2)
                pos[0] += 1
                if m2 == m3:
                    pos[1] += 1
                if m2 == m5:
                    pos[2] += 1
            elif m3 <= m5:
                res.append(m3)
                pos[1] += 1
                if m3 == m5:
                    pos[2] += 1
            else:
                res.append(m5)
                pos[2] += 1
            start += 1
        return res[-1]

# This is the second loop.
# obviously second loop is more concise.
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
