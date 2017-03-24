class Solution(object):

    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res, total, curr, zcnt = 0, 0, 0, 0
        for number in nums:
            if number == 0:
                zcnt += 1
                if zcnt == 1:
                    total, curr = curr + 1, 0
                else:
                    total, curr = 0, 0
            else:
                zcnt, curr, total = 0, curr + 1, total + 1
            res = max(total, res)
        return res
