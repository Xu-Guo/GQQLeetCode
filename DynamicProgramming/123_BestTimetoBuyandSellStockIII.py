class Solution(object):

    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n <= 1:
            return 0
        max_to_here = [0] * n
        max_from_here = [0] * n

        min_val = prices[0]
        for i in range(1, n - 1):
            max_to_here[i] = max(max_to_here[i - 1], prices[i] - min_val)
            min_val = min(prices[i], min_val)

        max_val = prices[n - 1]
        for i in range(n - 2, -1, -1):
            max_from_here[i] = max(max_from_here[i + 1], max_val - prices[i])
            max_val = max(prices[i], max_val)

        max_pro = max_from_here[0]
        for i in range(0, n - 1):
            max_pro = max(max_pro, max_to_here[i] + max_from_here[i + 1])

        return max_pro
