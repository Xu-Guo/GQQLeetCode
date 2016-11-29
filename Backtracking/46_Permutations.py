import copy
class Solution(object):

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        lst, tmplst = [], []
        self.backtrack(lst, tmplst, nums)
        return lst

    def backtrack(self, lst, tmplst, nums):
        if len(tmplst) == len(nums):
            # must use deep copy
            lst.append(copy.deepcopy(tmplst))
        else:
            for num in nums:
                if num in tmplst:
                    continue
                tmplst.append(num)
                self.backtrack(lst, tmplst, nums)
                tmplst.pop()
