class Solution(object):

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if word == "":
            return False
        len1 = len(board)
        len2 = len(board[0])
        for i in range(len1):
            for j in range(len2):
                if board[i][j] == word[0]:
                    board[i][j] = '*'
                    for p in [-1, 1]:
                        r = self.dosearch(board, word, i + p, j, 1)
                        if r:
                            return True
                        r = self.dosearch(board, word, i, j + p, 1)
                        if r:
                            return True
                    board[i][j] = word[0]
        return False

    def dosearch(self, b, s, i, j, pos):
        if pos == len(s):
            return True
        if i < 0 or j < 0 or i >= len(b) or j >= len(b[0]) or s[pos] != b[i][j]:
            return False
        b[i][j] = '*'
        for p in [-1, 1]:
            r = self.dosearch(b, s, i + p, j, pos+1)
            if r:
                return True
            r = self.dosearch(b, s, i, j + p, pos+1)
            if r:
               return True
        b[i][j] = s[pos]
        return False

