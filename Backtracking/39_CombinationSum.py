class Solution(object):

    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        lst = []
        candidates.sort()
        self.backtract(lst, [], 0, candidates, target, 0)
        return lst

    def backtract(self, lst, tmplist, list_sum, nums, target, start):
        if list_sum == target:
            lst.append(copy.deepcopy(tmplist))
        else:
            for x in range(start, len(nums)):
                tmplist.append(nums[x])
                list_sum = sum(tmplist)
                if list_sum <= target:
                    self.backtract(lst, tmplist, list_sum, nums, target, x)
                tmplist.pop()
