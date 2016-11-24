class Solution(object):

    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        rst = []
        nums.sort()
        self.backtrack(rst, [], nums, [])
        return rst

    def backtrack(self, lst, tmp, nums, pre):
        if len(pre) == len(nums):
            lst.append(copy.deepcopy(tmp))
        else:
            for x in range(len(nums)):
                if x in pre or (x > 0 and x - 1 not in pre and nums[x] == nums[x - 1]):
                    continue
                tmp.append(nums[x])
                pre.append(x)
                self.backtrack(lst, tmp, nums, pre)
                pre.pop()
                tmp.pop()
