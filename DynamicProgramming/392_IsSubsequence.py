class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) == 0:
            return True
        if len(t) == 0:
            return False
        c_idx = 0 
        curr = s[c_idx]
        for i in range(0, len(t)):
            if curr == t[i]:
                c_idx += 1
                if c_idx == len(s):
                    return True
                curr = s[c_idx]
        return False
        