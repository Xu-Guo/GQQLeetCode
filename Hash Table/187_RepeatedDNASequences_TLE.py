class Solution(object):

    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        result = []
        if len(s) < 10:
            return result
        n = len(s)
        for i in range(0, n - 10):
            des = s[i:i + 10]
            if des in result:
                continue
            for j in range(i + 1, n - 9):
                now = s[j: j + 10]
                if des == now:
                    result.append(now)
                    break
        return result
