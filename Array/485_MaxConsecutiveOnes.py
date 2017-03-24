class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res, curr = 0, 0
        for num in nums:
            curr = curr + 1 if num == 1 else 0
            res = max(res, curr)
        return res