class Solution(object):

    dic = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        ans = []
        if len(digits) == 0 or "0" in digits or "1" in digits:
            return ans
        self.search('', digits, 0, ans)
        return ans

    def search(self, prefix, digits, offsite, ret):
        if offsite == len(digits):
            ret.append(prefix)
            return ret

        letters = Solution.dic[int(digits[offsite])]
        for x in letters:
            self.search(prefix + x, digits, offsite + 1, ret)
