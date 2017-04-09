class Solution(object):

    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)
        if n == 0:
            return True
        lastIndex = n - 1

        for i in range(n - 2, -1, -1):
            if i + nums[i] >= lastIndex:
                lastIndex = i
        return lastIndex == 0