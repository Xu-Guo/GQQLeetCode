class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        res = [0] * n

        for i in range(n - 2, -1, -1):
            val = sys.maxint
            for j in range(min(n - 1, i + nums[i]), i, -1):
                val = min(val, 1 + nums[j])
            res[i] = val
        return res[0]