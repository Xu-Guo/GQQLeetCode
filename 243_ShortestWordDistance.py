class Solution(object):
    def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        pos1, pos2, dis = -1, -1, sys.maxint
        for i in range(len(words)):
            if words[i] == word1:
                pos1 = i
            if words[i] == word2:
                pos2 = i
            if not (pos1 == -1 or pos2 == -1):
                dis = min(abs(pos1 - pos2), dis)
        return dis