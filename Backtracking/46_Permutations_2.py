class Solution(object):

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        rst = []
        self.backtrack(rst, [], nums, [])
        return rst

    def backtrack(self, lst, tmp, nums, pre):
        if len(pre) == len(nums):
            lst.append(copy.deepcopy(tmp))
        else:
            for x in range(len(nums)):
                if x not in pre:
                    tmp.append(nums[x])
                    pre.append(x)
                    self.backtrack(lst, tmp, nums, pre)
                    pre.pop()
                    tmp.pop()
