public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            helper(board, i, 0, m, n);
            helper(board, i, n - 1, m, n);
        }

        for (int j = 0; j < n; j++) {
            helper(board, 0, j, m, n);
            helper(board, m - 1, j, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    public void helper(char[][] board, int i, int j, int m, int n) {
        
        // board[i][j] = '*';
        Set<String> set = new HashSet<>();
        if (!isSuit(board, i, j, set, m, n)) return;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        set.add(i + "_" + j);
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            board[p.x][p.y] = '*';
            int x = p.x - 1, y = p.y;
            if (isSuit(board, x, y, set, m, n)) {
                queue.offer(new Point(x, y));
                set.add(x + "_" + y);
            }
            x = p.x + 1;
            y = p.y;
            if (isSuit(board, x, y, set, m, n)) {
                queue.offer(new Point(x, y));
                set.add(x + "_" + y);
            }
            x = p.x;
            y = p.y - 1;
            if (isSuit(board, x, y, set, m, n)) {
                queue.offer(new Point(x, y));
                set.add(x + "_" + y);
            }
            x = p.x;
            y = p.y + 1;
            if (isSuit(board, x, y, set, m, n)) {
                queue.offer(new Point(x, y));
                set.add(x + "_" + y);
            }
        }
    }

    public boolean isSuit(char[][] board, int i, int j, Set<String> set, int m, int n) {
        if (i <0 || i >= m || j <0 || j >= n) return false;
        if (board[i][j] != 'O') return false;
        if (set.contains(i + "_" + j)) return false;
        return true;
    }
}