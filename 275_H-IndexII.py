class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        if n == 0:
            return 0
        low, high = 1, n
        while low <= high:
            mid = (low + high) / 2
            if citations[n - mid] >= mid:
                low = mid + 1
            else:
                high = mid - 1
        return high