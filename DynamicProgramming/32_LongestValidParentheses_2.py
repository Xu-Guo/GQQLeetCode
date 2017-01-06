class Solution(object):

    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        longest = [0 for x in len(s)]
        for i in range(len(s)):
            if s[i] == ")":
                if i - 1 >= 0 and s[i - 1] == "(":
                    longest[i] = 2 if i - 2 < 0 else 2 + s[i - 2]
                elif i - 1 >= 0 and s[i - 1] == ")":
                    if i - longest[i - 1] - 1 >= 0 and s[i - longest[i - 1] - 1] == "(":
                        if i - longest[i - 1] - 2 >= 0:
                            longest[i] = longest[i - 1] + 2 + longest[i - longest[i - 1] - 2]
                        else:
                            longest[i] = longest[i - 1] + 2
        return max(longest)
