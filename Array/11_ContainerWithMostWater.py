class Solution(object):

    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left, right = 0, len(height) - 1
        max_value = min(height[left], height[right]) * (right - left)
        while left < right:
            left_val = height[left]
            right_val = height[right]
            while left < right and height[left] <= height[right]:
                left += 1
                if height[left] > left_val:
                    max_value = max(max_value, min(height[left], height[right]) * (right - left))
                    left_val = height[left]
            while left < right and height[left] > height[right]:
                right -= 1
                if height[right] > right_val
                    max_value = max(max_value, min(height[left], height[right]) * (right - left))
                    right_val = height[right]
        return max_value
