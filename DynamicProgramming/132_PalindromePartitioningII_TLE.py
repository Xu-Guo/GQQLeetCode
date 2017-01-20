class Solution(object):

    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        if n <= 1:
            return 0
        res = [[0 for j in range(0, n)] for i in range(0, n)]
        for j in range(1, n):
            for i in range(j - 1, -1, -1):
                if not self.isPalindrome(s[i:j + 1]):
                    min_cut = res[i][i] + res[i + 1][j]
                    for k in range(i + 1, j):
                        min_cut = min(min_cut, res[i][k] + res[k + 1][j])
                    res[i][j] = min_cut + 1
        return res[0][n - 1]

    def isPalindrome(self, s):
        low, high = 0, len(s) - 1
        while low <= high:
            if s[low] != s[high]:
                return False
            low, high = low + 1, high - 1
        return True

# "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"
