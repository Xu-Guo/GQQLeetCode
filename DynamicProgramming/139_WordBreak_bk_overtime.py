class Solution(object):

    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        return self.bk(s, wordDict)

    def bk(self, s, wordDict):
        if len(s) == 0:
            return True
        for word in wordDict:
            index = s.find(word)
            if index > -1:
                r1 = self.bk(s[0:index], wordDict)
                r2 = self.bk(s[index + len(word):len(s)], wordDict)
                if r1 and r2:
                    return True
        return False
