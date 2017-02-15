class Solution(object):

    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)
        if n < 3:
            return False
        tbl = [0, 0, 0]
        for i in range(1, n):
            tbl[0], tbl[1], tbl[2] = i - 1, i, i - 1
            if nums[i] > nums[i - 1]:
                break
        start = tbl[1] + 1
        for i in range(start, n):
            if nums[i] > nums[tbl[1]]:
                return True
            if nums[i] < nums[tbl[2]]:
                tbl[2] = i
            elif nums[i] < nums[tbl[1]] and nums[i] > nums[tbl[2]]:
                tbl[0] = tbl[2]
                tbl[1] = i
        return False
