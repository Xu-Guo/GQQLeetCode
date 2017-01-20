class Solution(object):

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        lst = []
        self.backtrack(s, lst, [], 0, len(s))
        return lst

    def backtrack(self, s, lst, tmplist, low, high):
        if low == len(s):
            lst.append(copy.deepcopy(tmplist))
        else:
            for i in range(low+1, high+1):
                if self.isPalindrome(s[low:i]):
                    tmplist.append(s[low:i])
                    self.backtrack(s, lst, tmplist, i, len(s))
                    tmplist.pop()

    def isPalindrome(self, s):
        low, high = 0, len(s) - 1
        while low <= high:
            if s[low] != s[high]:
                return False
            low, high = low + 1, high - 1
        return True

# this is the second round by myself.
# the second use return DFS.
# the is the same as 140_WordBreakII_dfs_cache.java
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
