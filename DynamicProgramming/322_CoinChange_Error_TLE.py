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
        # reversed(sorted(coins)
        coins.sort(reverse=True)
        return self.bk(coins, 0, len(coins), amount)

    def bk(self, coins, s, end, amount):
        if amount == 0:
            return 0
        for i in range(s, end):
            if coins[i] <= amount:
                y = self.bk(coins, s, end, amount - coins[i])
                if y != -1:
                    return 1 + y
        return -1

if __name__ == '__main__':
    s = Solution()
    print s.coinChange([186,419,83,408], 6249)
# this method is Wrong.
# [186,419,83,408]
# 6249
