class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        lst = []
        self.backtrace(lst, '', 0, 0, n)
        return lst
        
    def backtrace(self, lst, tmp, left, right, max):
        if left + right == 2*max:
            lst.append(tmp)
        else:
            if left < max:
                self.backtrace(lst, tmp + '(', left + 1, right, max)
            if right < left:
                self.backtrace(lst, tp + ')', left, rmight + 1, max)