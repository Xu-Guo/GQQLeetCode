
class Solution(object):

    def getPermutation(self, n, k):
        if n <= 0 or k <= 0 or n > 9:
            return ''
        fact = [1, 1]
        nums = []
        for x in range(2, 10):
            fact.append(fact[-1] * x)
        if k > fact[n]:
            return ''
        for x in range(1, n + 1):
            nums.append(x)
        lst = []
        self.backtrack(lst, fact, nums, n - 1, k - 1)
        return "".join(str(x) for x in lst)

    def backtrack(self, lst, fact, nums, n, k):
        if n == 0:
            lst.append(nums.pop(0))
        elif n > 0:
            index = k / fact[n]
            k = k - index * fact[n]
            lst.append(nums.pop(index))
            self.backtrack(lst, fact, nums, n - 1, k)
