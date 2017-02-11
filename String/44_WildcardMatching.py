class Solution(object):

    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        m, n = len(s), len(p)
        match = [[False for j in range(n + 1)] for i in range(m + 1)]
        match[0][0] = True
        for j in range(1, n + 1):
            if match[0][j - 1] and p[j - 1] == "*":
                match[0][j] = True

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                c = p[j - 1]
                if c == "*":
                    if match[i][j - 1] or match[i - 1][j]:
                        match[i][j] = True
                elif s[i - 1] == c or c == "?":
                    if match[i - 1][j - 1]:
                        match[i][j] = True
        return match[m][n]