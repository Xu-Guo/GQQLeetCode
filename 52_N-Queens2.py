class Solution(object):
    def __init__(self):
        self.num = 0
    
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [["." for i in range(n)] for j in range(n)]
        self.helper(board, 0, n)
        return self.num

    def helper(self, board, line, n):
        if line >= n:
            # success t, add board to list.
            return True
        for j in range(n):
            old = board[line]
            tmp = list(board[line])
            tmp[j] = "Q"
            board[line] = "".join(tmp)
            if self.valid(board, line, j, n):
                if self.helper(board, line + 1, n):
                    self.num += 1
            board[line] = old
        return False

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
