class Solution(object):

    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n >= 11:
            return 0
        if n == 0:
            return 1
        sumb, f = 10, 9
        for i in range(2, n + 1):
            f = f * (11 - i)
            sumb = sumb + f
        return sumb
