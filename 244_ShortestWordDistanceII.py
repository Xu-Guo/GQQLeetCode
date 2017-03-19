class WordDistance(object):

    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.dict = {}
        for i in range(len(words)):
            if words[i] in self.dict:
                self.dict[words[i]].append(i)
            else:
                self.dict[words[i]] = [i]



    def shortest(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        list1 = self.dict[word1]
        list2 = self.dict[word2]
        i, j, dis = 0, 0, abs(list1[0] - list2[0])
        while i < len(list1) and j < len(list2):
            dis = min(dis, abs(list1[i] - list2[j]))
            if list1[i] < list2[j]:
                i += 1
            else:
                j += 1
        return dis


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)

class WordDistance(object):
    def __init__(self, words):
        self.d = {}
        for i, w in enumerate(words):
            self.d[w] = self.d.get(w, []) + [i]

    def shortest(self, w1, w2):
        a, b = self.d[w1], self.d[w2]
        m, n, i, j, res = len(a), len(b), 0, 0, sys.maxsize
        while i < m and j < n:
            res = min(res, abs(a[i] - b[j]))
            if a[i] < b[j]:
                i += 1
            else:
                j += 1
        return res