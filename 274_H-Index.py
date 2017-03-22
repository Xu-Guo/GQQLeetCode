class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        if (n == 0):
            return 0
        sums = [0] * (n + 1)

        for cit in citations:
            if cit == 0:
                continue
            if cit >= n:
                sums[n] += 1
            else:
                sums[cit] += 1

        for i in range(n, -1, -1):
            if i < n:
                sums[i] += sums[i + 1]
            if sums[i] >= i:
                return i
        return 0