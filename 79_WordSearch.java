public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                boolean res = helper(board, i, j, 0, word);
                if (res) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int i, int j, int start, String word) {
        if (start == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) return false;
        char tmp = board[i][j];
        board[i][j] = '*';
        boolean left = helper(board, i - 1, j, start + 1, word);
        if (left) return true;
        boolean right = helper(board, i + 1, j, start + 1, word);
        if (right) return true;
        boolean top = helper(board, i, j - 1, start + 1, word);
        if (top) return true;
        boolean bottom = helper(board, i, j + 1, start + 1, word);
        if (bottom) return true;
        board[i][j] = tmp;
        return false;
    }
}