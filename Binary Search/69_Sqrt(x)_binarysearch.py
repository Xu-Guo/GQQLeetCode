class Solution(object):

    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        small, big = 1, x
        while small <= big:
            mid = small + (big - small) / 2
            if mid == x / mid:
                return mid
            elif mid > x / mid:
                big = mid - 1
            else:
                if (mid + 1) > x / (mid + 1):
                    return mid
                else:
                    small = mid + 1
        return 0