class Solution(object):

    def splitArray(self, nums, m):
        """
        :type nums: List[int]
        :type m: int
        :rtype: int
        """
        l, r = max(nums), sum(nums)
        while l <= r:
            mid = (l + r) / 2
            if self.valid(nums, mid, m):
                r = mid - 1
            else:
                l = mid + 1
        return l

    def valid(self, nums, target, m):
        cnt, total = 0, 0
        for num in nums:
            total += num
            if total > target:
                total, cnt = num, cnt + 1
                if cnt >= m:
                    return False
        return True
