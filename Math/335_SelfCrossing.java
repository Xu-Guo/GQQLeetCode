public class Solution {
    public boolean isSelfCrossing(int[] x) {
        Set<Point> set = new HashSet<>();
        Point p = new Point(0, 0);
        int[] curr = {0, 0};
        set.add(p);
        for (int i = 0; i < x.length; x++) {
            int val = x[i];
            int pos = i % 4;
            if (pos == 0) {
                curr[1] += val;
            } else if (pos == 1) {
                curr[0] -= val;
            } else if (pos == 2) {
                curr[1] -= val;
            } else {
                curr[0] += val;
            }
            
            Point p = new Point(curr[0], curr[1]);
            if (!set.add(p)) return true;
        }
        return false;
    }
}

class Point {

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x, y;

    @Override
    public boolean equals(Object obj) {
        Point mp = (Point) obj;
        return mp.x == this.x && mp.y == this.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }
}