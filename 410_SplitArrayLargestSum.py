class Solution(object):

    def splitArray(self, nums, m):
        """
        :type nums: List[int]
        :type m: int
        :rtype: int
        """
        if len(nums) == 0:
            return 0

    def helper(self, nums, m, start, nlen):
        if m > nlen:
            return 0
        if m == 1:
            # return from start to end
            return sum(nums[start: nlen])
        for i in range(start, :
            pass

