# this is the second round.
# the code has been merged into 131_PalindromePartitioning.py
class Solution(object):

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        return self.dfs(s)

    def dfs(self, s):
        result = []
        if len(s) == 0:
            return []
        for i in range(1, len(s) + 1):
            if self.is_palindrome(s[0:i]):
                sub_res = self.dfs(s[i:])
                if len(sub_res) == 0:
                    result.append([s[0:i]])
                else:
                    for sub in sub_res:
                        result.append([s[0:i]] + sub)
        return result

    def is_palindrome(self, s):
        i, j = 0, len(s) - 1
        while i <= j:
            if s[i] != s[j]:
                return False
            i, j = i + 1, j - 1
        return True
