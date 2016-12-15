class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        if num < 0:
            return []
        ret = [0] * (num + 1)
        if num >= 1:
            ret[1] = 1
            for x in range(2, num+1):
                d = x/2
                r = x%2
                ret[x] = ret[d] + ret[r]
        return ret

