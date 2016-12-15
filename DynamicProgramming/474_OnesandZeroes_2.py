class Solution(object):

    def findMaxForm(self, strs, m, n):
        """
        :type strs: List[str]
        :type m: int
        :type n: int
        :rtype: int
        """
        if len(strs) == 0:
            return 0
        curr = strs[0]
        p, q = m, n
        for c in curr:
            if c == '0':
                p -= 1
            else:
                q -= 1
            if p < 0 or q < 0:
                break
        if p < 0 or q < 0:
            return self.findMaxForm(strs[1:], m, n)
        else:
            return max(self.findMaxForm(strs[1:], m, n), 1 + self.findMaxForm(strs[1:], p, q))
