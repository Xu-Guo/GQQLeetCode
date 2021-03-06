class Solution(object):

    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        m, n = len(s), len(p)
        if n == 0:
            return True if m == 0 else False
        if m == 0:
            return self.isMatchNone(p)

        r = [[0 for x in range(n)] for y in range(m)]
        src = s[0]
        for j in range(n):
            des = p[j]
            if des == src or des == ".":
                if self.isMatchNone(p[0:j]):
                    r[0][j] = 1
            elif des == "*":
                if r[0][j - 1] == 1 or (j - 2 >= 0 and r[0][j - 2] == 1):
                    r[0][j] = 1
        # print r
        for i in range(1, m):
            src = s[i]
            for j in range(1, n):
                des = p[j]
                if des == src or des == ".":
                    r[i][j] = r[i - 1][j - 1]
                elif des == "*":
                    if r[i][j - 1] == 1 or (j - 2 >= 0 and r[i][j - 2] == 1):
                        r[i][j] = 1
                    if (src == p[j - 1] or p[j - 1] == ".") and (r[i - 1][j - 1] == 1 or r[i - 1][j] == 1):
                        r[i][j] = 1
        return True if r[m - 1][n - 1] == 1 else False

    def isMatchNone(self, p):
        if len(p) % 2 != 0:
            return False
        for i in range(1, len(p), 2):
            if p[i] != "*":
                return False
        return True