class Solution(object):

    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_val, min_val = 0, 2147483647
        for num in nums:
            if num > 0:
                max_val = max(max_val, num)
                min_val = min(min_val, num)
        if max_val <= 0:
            return 1
        if min_val > 1:
            return 1
        res = [False] * (max_val + 1)
        res[0] = True
        for num in nums:
            if num > 0:
                res[num] = True

        for i in range(max_val + 1):
            if not res[i]:
                return i
        return max_val + 1
