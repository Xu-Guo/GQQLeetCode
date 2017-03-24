class Solution(object):

    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        if num == 1 or num == 2 or num == 3 or num == 4 or num == 5:
            return True
        if num % 2 == 0:
            return self.isUgly(num / 2)
        if num % 3 == 0:
            return self.isUgly(num / 3)
        if num % 5 == 0:
            return self.isUgly(num / 5)
        return False