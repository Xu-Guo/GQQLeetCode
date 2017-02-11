class Solution(object):

    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n <= 0:
            return ""
        res = "1"
        for i in range(1, n):
            res = self.countToString(res)
        return res

    def countToString(self, s):
        curr = s[0]
        cnt = 1
        res = ""
        for i in range(1, len(s)):
            if curr == s[i]:
                cnt += 1
            else:
                res += str(cnt) + curr
                cnt = 1
                curr = s[i]
        res += str(cnt) + curr
        return res
