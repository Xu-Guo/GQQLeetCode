class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [["." for i in range(n)] for j in range(n)]
        res = []
        self.helper(res, board, 0, n)
        return res;
        
    def helper(self, res, board, line, n):
        if line >= n:
            # success result, add board to list.
            res.append(copy.deepcopy(board))
            return
        for j in range(n):
            old = board[line]
            tmp = list(board[line])
            tmp[j] = "Q"
            board[line] = "".join(tmp)
            if self.valid(board, line, j, n):
                self.helper(res, board, line + 1, n)
            board[line] = old

    def valid(self, board, line, col, n):
        for i in range(line - 1, -1, -1):
            if board[i][col] == "Q":
                return False
        for j in range(col - 1, -1, -1):
            if board[line][j] == "Q":
                return False
        i, j = line - 1, col - 1
        while i >= 0 and j >= 0:
            if board[i][j] == "Q":
                return False
            i, j = i - 1, j - 1
        i, j = line - 1, col + 1
        while i >= 0 and j < n:
            if board[i][j] == "Q":
                return False
            i, j = i - 1, j + 1
        return True
