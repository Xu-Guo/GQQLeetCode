class Solution(object):
    def shortestWordDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        pos1, pos2, dis = -1, -1, sys.maxint
        for i in range(len(words)):
            curr = words[i]
            if curr == word1:
                if word1 == word2:
                    if pos1 == 1 or pos1 < pos2:
                        pos1 = i
                    else:
                        pos2 = i
                else:
                    pos1 = i
            elif curr == word2:
                pos2 = i

            if pos1 != -1 and pos2 != -1:
                dis = min(dis, abs(pos1 - pos2))
        return dis