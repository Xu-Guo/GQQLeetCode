class Solution(object):

    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == word[0]:
                    board[i][j] = '*'
                    ret = self.dosearch(board, word, 1, i, j)

                    if ret:
                        return True
                    board[i][j] = word[0]
        return False

    def dosearch(self, board, word, start, i, j, exists):
        if start == len(word):
            return True
        if i - 1 >= 0 and board[i - 1][j] == word[start]:
            board[i - 1][j] = '*'
            ret = self.dosearch(board, word, start + 1, i - 1, j)
            if ret:
                return True
            board[i - 1][j] = word[start]
        if i + 1 < len(board) and board[i + 1][j] == word[start]:
            board[i + 1][j] = '*'
            ret = self.dosearch(board, word, start + 1, i + 1, j)
            if ret:
                return True
            board[i + 1][j] = word[start]
        if j - 1 >= 0 and board[i][j - 1] == word[start]:
            board[i][j - 1] = '*'
            ret = self.dosearch(board, word, start + 1, i, j - 1)
            if ret:
                return True
            board[i][j - 1] = word[start]
        if j + 1 < len(board[0]) and board[i][j + 1] == word[start]:
            board[i][j + 1] = '*'
            ret = self.dosearch(board, word, start + 1, i, j + 1)
            if ret:
                return True
            board[i][j + 1] = word[start]
        return False
