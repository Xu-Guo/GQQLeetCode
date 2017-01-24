class Solution(object):

    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        max_area = 0
        for i in range(0, n - 1):
            for j in range(i + 1, n):
                max_area = max(max_area, min(height[i], height[j]) * (j - i))
        return max_area
