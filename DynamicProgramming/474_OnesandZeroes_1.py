class Solution(object):

    max_v = 0

    def findMaxForm(self, strs, m, n):
        """
        :type strs: List[str]
        :type m: int
        :type n: int
        :rtype: int
        """
        if m == 0 and n == 0:
            return 0
        return self.bk(strs, m, n, 0)

    def bk(self, strs, m, n, curr_v):
        if len(strs) == 0 or (m == 0 and n == 0):
            return curr_v

        for i in range(0, len(strs)):
            s = strs[i]
            p, q = m, n
            for c in s:
                if c == "0":
                    p -= 1
                else:
                    q -= 1
                if p < 0 or q < 0:
                    break
            if p >= 0 and q >= 0:
                val = self.bk(strs[i + 1:], p, q, curr_v + 1)
                Solution.max_v = val if val > Solution.max_v else Solution.max_v
        return Solution.max_v

if __name__ == '__main__':
    s = Solution()
    v = s.findMaxForm(["10", "0", "1"], 1, 1)
    print(v)