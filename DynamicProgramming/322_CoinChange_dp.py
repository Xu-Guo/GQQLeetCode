class Solution(object):

    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0:
            return 0
        if len(coins) == 0:
            return -1
        dp = [-1 for i in range(0, amount + 1)]
        dp[0] = 0
        for i in range(1, amount + 1):
            min_num = 2147483647
            for c in coins:
                if i == c:
                    min_num = 1
                    break
                elif i > c and dp[i - c] != -1:
                    min_num = min(min_num, dp[i - c] + 1)
            if min_num < 2147483647:
                dp[i] = min_num
        return dp[amount]
