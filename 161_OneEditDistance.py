class Solution(object):

    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        cnt = 0
        if len(s) == len(t):
            # check one replace
            for i in range(len(s)):
                if s[i] != t[i]:
                    cnt += 1
        elif len(s) - len(t) == 1:
            cnt = self.cmp(s, t)
        elif len(t) - len(s) == 1:
            cnt = self.cmp(t, s)
        else:
            return False
        return cnt == 1

    def cmp(self, longer, shorter):
        length = len(shorter)
        i = 0
        cnt = 0
        while i < length and longer[i] == shorter[i]:
            i += 1
        cnt += 1
        while i < length:
            if longer[i + 1] != shorter[i]:
                cnt += 1
                break
            i += 1
        return cnt