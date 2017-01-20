class Solution(object):
# error test case : abbab
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) <= 1:
            return 0
        res = [0] * len(s)
        for i in range(1, len(s)):
            for j in range(0, i + 1):
                if self.is_palindrome(s[j:i + 1]):
                    if j == 0:
                        res[i] = 0
                    else:
                        res[i] = res[j-1] + 1
                    break
        print res
        return res[-1]

    def is_palindrome(self, s):
        i, j = 0, len(s) - 1
        while i <= j:
            if s[i] != s[j]:
                return False
            i, j = i + 1, j - 1
        return True
