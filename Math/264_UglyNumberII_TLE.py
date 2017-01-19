class Solution(object):

    # this solution will TLE at the number bigger than 405
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = []
        for i in (1, 2, 3, 4, 5):
            result.append(i)
        if n in (1, 2, 3, 4, 5):
            return n
        curr = 5
        data = 6
        while curr < n:
            if self.isUgly(data, result):
                result.append(data)
                curr += 1
                if curr == n:
                    break
            data += 1
        return data

    def isUgly(self, data, result):
        if data % 2 == 0 and (data / 2) in result:
            return True
        if data % 3 == 0 and (data / 3) in result:
            return True
        if data % 5 == 0 and (data / 5) in result:
            return True
        return False
