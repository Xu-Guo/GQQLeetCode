class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        n = len(s)
        if len(wordDict) == 0:
            return False
        res = [False] * (n + 1)
        res[n] = True

        for i in range(n - 1, -1, -1):
            for word in wordDict:
                if s[i:].startswith(word) and res[i + len(word)]:
                    res[i] = True
                    break
        return res[0]
