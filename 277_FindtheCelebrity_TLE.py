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
        for i in range(n):
            step1, step2 = True, True
            for j in range(n):
                if j != i:
                    if knows(i, j):
                        step1 = False
                        break
            if not step1:
                continue
            for j in range(n):
                if j != i:
                    if not knows(j, i):
                        step2 = False
                        break
            if step2:
                return i
        return -1
