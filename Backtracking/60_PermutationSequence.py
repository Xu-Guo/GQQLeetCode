import copy


class Solution(object):

    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        lst = []
        nums = [i for i in range(1, n + 1)]
        self.bk(lst, nums, [], n)
        # print lst[k]
        return ''.join([str(i) for i in lst[k]])

    def bk(self, lst, nums, tmp, n):
        if len(tmp) == n:
            lst.append(copy.deepcopy(tmp))
        else:
            for i in nums:
                if i not in tmp:
                    tmp.append(i)
                    self.bk(lst, nums, tmp, n)
                    tmp.pop()

if __name__ == '__main__':
    s = Solution()
    print s.getPermutation(3, 5)
