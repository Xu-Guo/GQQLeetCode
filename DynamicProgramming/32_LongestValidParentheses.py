class Solution(object):

    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stk = []
        for i in range(len(s)):
            if s[i] == "(":
                stk.append(i)
            else:
                if len(stk) > 0 and s[stk[-1]] == "(":
                    stk.pop()
                else:
                    stk.append(i)
        # print stk
        if len(stk) == 0:
            return len(s)
        else:
            longest = 0
            for i in range(1, len(stk)):
                longest = max(longest, stk[i] - stk[i - 1] - 1)
            longest = max(stk[0], longest)
            longest = max(len(s) - stk[-1] - 1, longest)
            return longest
