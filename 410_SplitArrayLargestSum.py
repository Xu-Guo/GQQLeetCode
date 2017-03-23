class Solution(object):

    def splitArray(self, nums, m):
        """
        :type nums: List[int]
        :type m: int
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        n = len(nums)
        ret = max(nums)
        if m == n:
            return ret

        for i in range(1, n - m):
            minval = sys.maxint
            minidx = -1
            for j in range(0, n - i):
                if nums[j] + nums[j + 1] < imin:
                    minidx, minval = j, nums[j] + nums[j + 1]
            # [0 : minidx - 1] original value
            nums[minidx] = minval
            for j in range(minidx + 1, n - i):
                nums[j] = nums[j + 1]
            ret = max(ret, minval)
        return ret
