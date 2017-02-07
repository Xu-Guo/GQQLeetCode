class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n < 10:
            return True if n in [1,7] else False
        new_sum = 0
        while n >= 10:
            new_sum += (n % 10) * (n % 10)
            n = n / 10
        new_sum += n * n
        return self.isHappy(new_sum)
