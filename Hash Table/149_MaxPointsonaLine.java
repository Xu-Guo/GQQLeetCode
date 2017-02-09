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
        List<NewPoint> newList = new ArrayList<>();
        for (Point point : points) {
            NewPoint np = new NewPoint(point.x, point.y);
            if (!map.containsKey(np)) {
                map.put(np, 1);
            } else {
                map.put(np, map.get(np) + 1);
            }
        }

        for (NewPoint np : map.keySet()) {
            newList.add(np);
        }

        n = newList.size();
        if(n == 1) return map.get(newList.get(0));
        if(n == 2) return map.get(newList.get(0)) + map.get(newList.get(1));
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int currNum = map.get(newList.get(i)) + map.get(newList.get(j));
                long x1 = newList.get(i).x;
                long y1 = newList.get(i).y;
                long x2 = newList.get(j).x;
                long y2 = newList.get(j).y;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    long x = newList.get(k).x;
                    long y = newList.get(k).y;
                    if ((y2 - y1) * (x - x1) == (x2 - x1) * (y - y1))
                        currNum += map.get(newList.get(k));
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