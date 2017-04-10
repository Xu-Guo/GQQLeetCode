class Solution(object):

    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return 0
        max_val, min_val = max(nums), min(nums)
        n = len(nums)
        gap = int(math.ceil(float(max_val - min_val) / float(n - 1)))
        maxint, minint = sys.maxint, - sys.maxint - 1
        min_buk = [maxint] * (n - 1)
        max_buk = [minint] * (n - 1)

        # update min_buk and max_buk
        for number in nums:
            if number == max_val or number == min_val:
                continue
            idx = (number - min_val) / gap

            min_buk[idx] = min(min_buk[idx], number)
            max_buk[idx] = max(max_buk[idx], number)

        pre, res = min_val, 0
        for i in range(n - 1):
            if min_buk[i] == maxint:
                continue
            res = max(min_buk[i] - pre, res)
            pre = max_buk[i]
        res = max(res, max_val - pre)
        return res