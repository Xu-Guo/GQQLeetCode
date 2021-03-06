public class Solution {

    public boolean exist(char[][] board, String word) {
        int len1 = board.length;
        int len2 = board[0].length;
        char targ = word.charAt(0);
        for (int i=0; i<len1; i++) {
            for (int j=0; j<len2; j++) {
                if (board[i][j] == targ) {
                    board[i][j] = '*';
                    boolean r = search(board, word, i-1, j, 1);
                    if (r) {
                        return true;
                    }
                    r = search(board, word, i+1, j, 1);
                    if (r) {
                        return true;
                    }
                    r = search(board, word, i, j-1, 1);
                    if (r) {
                        return true;
                    }
                    r = search(board, word, i, j+1, 1);
                    if (r) {
                        return true;
                    }
                    board[i][j] = targ;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] b, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i<0 || j<0 || i >= b.length || j >= b[0].length || b[i][j] != word.charAt(pos)) {
            return false;
        }
        b[i][j] = '*';
        boolean r = search(b, word, i-1, j, pos+1);
        if (r) {
            return true;
        }
        r = search(b, word, i+1, j, pos+1);
        if (r) {
            return true;
        }
        r = search(b, word, i, j-1, pos+1);
        if (r) {
            return true;
        }
        r = search(b, word, i, j+1, pos+1);
        if (r) {
            return true;
        }
        b[i][j] = word.charAt(pos);
        return false;
    }

}