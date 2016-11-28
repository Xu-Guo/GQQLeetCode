class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
    
    def backtract(self, lst, tmp, n):
        if len(tmp) == 2*n:
            lst.append(tmp)
        else:
            left = 0
            for i in range(0, n):
                tmp.append('(')
                left += 1
            for j in range(left):
                tmp.append(')')
            self.backtract(lst, tmp, 
                )
