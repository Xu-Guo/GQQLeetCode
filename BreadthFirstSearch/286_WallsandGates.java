public class Solution {
    int inf = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            // System.out.println(curr.i + " " + curr.j + " " + curr.val);
            updateBoard(rooms, curr.i - 1, curr.j, queue, curr.val + 1);
            updateBoard(rooms, curr.i + 1, curr.j, queue, curr.val + 1);
            updateBoard(rooms, curr.i, curr.j - 1, queue, curr.val + 1);
            updateBoard(rooms, curr.i, curr.j + 1, queue, curr.val + 1);
        }
    }

    public void updateBoard(int[][] rooms, int i, int j, Queue<Node> queue, int value) {
        if (i<0 || i>=rooms.length || j<0 || j>=rooms[0].length || rooms[i][j] != inf) return;
        // System.out.println(i + " - " + j + " - " + value);
        rooms[i][j] = value;
        queue.offer(new Node(i, j, value));
    }
}

class Node {
    public Node(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;

    }
    int i;
    int j;
    int val;
}