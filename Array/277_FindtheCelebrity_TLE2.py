# The knows API is already defined for you.
# @param a, person a
# @param b, person b
# @return a boolean, whether a knows b
# def knows(a, b):


class Solution(object):

    def findCelebrity(self, n):
        """
        :type n: int
        :rtype: int
        """
        return self.devide(0, n - 1)

    def devide(self, start, end):
        if start > end:
            return -1
        if start == end:
            return start
        if end == start + 1:
            a = knows(start, end)
            b = knows(end, start)
            if a and not b:
                # start knows end, end does not know start
                return end
            elif not a and b:
                return start
            else:
                return -1
        mid = start + (end - start) / 2
        c1 = self.devide(start, mid)
        c2 = self.devide(mid + 1, end)
        if c1 == -1 and c2 == -1:
            return -1
        else:
            i = mid + 1
            while i <= end:
                if knows(c1, i) or not knows(i, c1):
                    break
                i += 1
            if i > end:
                return c1
            j = start
            while j <= mid:
                if knows(c2, j) or not knows(j, c2):
                    break
                j += 1
            if j > mid:
                return c2
            return -1
