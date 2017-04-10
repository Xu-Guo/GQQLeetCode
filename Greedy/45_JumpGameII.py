class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0 or n == 1:
            return 0
        res = [0] * n
        lastIdx = 1
        for i in range(n):
            if i + nums[i] >= n - 1:
                return res[i] + 1
            for j in range(lastIdx, i + nums[i] + 1):
                res[j] = res[i] + 1
            lastIdx = max(lastIdx, i + nums[i] + 1)
        return -1

