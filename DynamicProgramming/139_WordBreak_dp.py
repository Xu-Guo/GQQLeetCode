class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # f[i] means s[0:i] an be segmented into a space-separated sequence of one or more dictionary words.
        # when j<i, and f[j] == True, and s[j:i] in Dict. then f[i] = True
        res = [False for x in range(len(s)+1)]
        res[0] = True
        for i in range(1, len(s)+1):
            for j in range(0, i):
                if res[j] and (s[j:i] in wordDict):
                    res[i] = True
                    break
        return res[-1]