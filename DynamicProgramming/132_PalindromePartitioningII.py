class Solution(object):
    # error test case : abbab

    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        # b[i], the minCut [i:n-1]. the result is b[0]
        # pay[i][j]. to charge whether [i:j] is Pal.
        # if pay[i][j] is true:
        #   if j=n-1, b[i] = 0
        #   else. b[i] = min(b[i], 1+b[j+1])
        n = len(s)
        pal = [[False for i in range(n)] for j in range(n)]
        b = [0 for i in range(n)]
        for i in range(n - 1, -1, -1):
            b[i] = n - 1 - i
            for j in range(i, n):
                # use this if to check [i:j] is palindrome
                # print i, j
                if s[i] == s[j] and (j - i < 2 or pal[i + 1][j - 1]):
                    pal[i][j] = True
                    if j == n - 1:
                        b[i] = 0
                    else:
                        b[i] = min(b[i], 1 + b[j + 1])
        return b[0]