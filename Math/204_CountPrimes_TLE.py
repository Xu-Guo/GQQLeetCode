class Solution(object):

    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2:
            return 0
        table = [False] * n
        for i in range(3, n):
            if i % 2 == 0:
                table[i] = True
        for i in range(3, n):
            if i * i > n:
                break
            if not table[i]:
                for j in range(i + 1, n):
                    if j % i == 0:
                        table[j] = True
        cnt = 0
        for x in range(2, n):
            if not table[x]:
                cnt += 1
        return cnt

if __name__ == '__main__':
    s = Solution()
    # if using this test case, it will be TLE
    print s.countPrimes(499979)
