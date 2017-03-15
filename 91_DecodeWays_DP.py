class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        res = [0] * n
        if n == 0:
            return 0
        if s[n - 1] != "0":
            res[n - 1] = 1
        if n - 1 == 0:
            return res[n - 1]
        if s[n - 2] != "0":
            if int(s[n-2:]) <= 26:
                res[n - 2] = res[n - 1] + 1
            else:
                res[n - 2] = res[n - 1]
        for i in range(n - 3, -1, -1):
            if s[i] != "0":
                cnt1 = res[i + 1]
                cnt2 = 0 if int(s[i : i+2]) > 26 else res[i + 2]
                res[i] = cnt1 + cnt2
        # print res
        return res[0]

class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        # res = [0] * n
        if n == 0:
            return 0
        if s[n - 1] != "0":
            sub = 1
        if n - 1 == 0:
            return res[n - 1]
        if s[n - 2] != "0":
            if int(s[n-2:]) <= 26:
                pre = sub + 1
            else:
                pre = sub
        for i in range(n - 3, -1, -1):
            if s[i] != "0":
                cnt1 = pre
                cnt2 = 0 if int(s[i : i+2]) > 26 else sub
                sub = pre
                pre = cnt1 + cnt2
        # print res
        return pre



