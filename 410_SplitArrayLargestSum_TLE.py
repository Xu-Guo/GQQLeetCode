class Solution(object):

    def splitArray(self, nums, m):
        """
        :type nums: List[int]
        :type m: int
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        return self.helper(nums, m, 0, len(nums), {})

    def helper(self, nums, m, start, nlen, dict):
        key = str(m) + "_" + str(start)
        if key in dict:
            return dict[key]
        if m > nlen:
            return 0
        if m == 1:
            # return from start to end
            total = sum(nums[start: nlen]);
            dict[key] = total
            return total
        res = sys.maxint
        for i in range(start + 1, nlen - m + 2):
            sum1 = sum(nums[start : i])
            sum2 = self.helper(nums, m - 1, i, nlen, dict)
            # print i, sum1, sum2
            sumf = max(sum1, sum2)
            res = min(sumf, res)
        dict[key] = res
        return res

