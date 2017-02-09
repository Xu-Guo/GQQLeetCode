/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int maxNum = 0;
        int n = points.length;
        if (n <= 2) return n;
        HashMap<NewPoint, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int currNum = 2;
                long x1 = points[i].x;
                long y1 = points[i].y;
                long x2 = points[j].x;
                long y2 = points[j].y;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    long x = points[k].x;
                    long y = points[k].y;
                    if ((y2 - y1) * (x - x1) == (x2 - x1) * (y - y1)) currNum++;
                }
                maxNum = Math.max(maxNum, currNum);
            }
        }
        return maxNum;
    }
}


class NewPoint extends Point {
    public NewPoint() {
        super();
    }

    public NewPoint(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        NewPoint np = (NewPoint) obj;
        return np.x == this.x && np.y == this.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }
}