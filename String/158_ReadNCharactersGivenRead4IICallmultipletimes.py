# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
# def read4(buf):


class Solution(object):

    def __init__(self):
        self.point = -1
        self.size = 4
        self.cache = [0] * self.size

    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Maximum number of characters to read (int)
        :rtype: The number of characters read (int)
        """
        if n == 0:
            return 0
        ret = [0] * n
        i = 0
        while i < n:
            if self.point >= self.size and self.size < 4:
                break
            if self.point > -1 and self.point < self.size:
                ret[i] = self.cache[self.point]
                i += 1
                self.point += 1
            else:
                number = read4(buf)
                self.size = number
                self.point = 0
                for j in range(number):
                    self.cache[j] = buf[j]

        for j in range(i):
            buf[j] = ret[j]

        return i

