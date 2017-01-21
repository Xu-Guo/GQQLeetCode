class Solution(object):

    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        ret = [None] * (len(s)+1)
        ret[0] = [""]
        for i in range(1, len(s) + 1):
            for j in range(0, i):
                if ret[j] is not None and s[j:i] in wordDict:
                    if ret[i] is None:
                        ret[i] = []
                    for sub in ret[j]:
                        ret[i].append(s[j:i] if sub == "" else sub + " " + s[j:i])
        return [] if ret[len(s)] is None else ret[len(s)]

if __name__ == '__main__':
    s = Solution()
    print s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"])