class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        maxV, i, cnt = 1, 0, 0
        while maxV - 1 < n:
            if i >= len(nums) or nums[i] > maxV:
                maxV += maxV
                cnt += 1
            else:
                maxV += nums[i]
                i += 1
        return cnt