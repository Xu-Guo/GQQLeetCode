class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        minv = nums[0]
        ret = minv
        for i in range(1, len(nums)):
            minv = nums[i] if minv <= 0 else minv + nums[i]
            ret = minv if minv > ret else ret
        return ret