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
