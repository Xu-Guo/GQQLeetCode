/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.math.BigDecimal;
import java.math.MathContext;
// BigDecimal dy = new BigDecimal(points[j].y - points[i].y);
//                 BigDecimal dx = new BigDecimal(points[j].x - points[i].x);
//                 BigDecimal k = dy.divide(dx, MathContext.DECIMAL128);
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int samex = 1;
            int samep = 0;
            Map<BigDecimal, Integer> map = new HashMap<>();
            Point p_i = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                Point p_j = points[j];
                if (p_i.x == p_j.x) {
                    samex++;
                    if (p_i.y == p_j.y) samep++;
                    continue;
                }
                BigDecimal dy = new BigDecimal(points[j].y - points[i].y);
                BigDecimal dx = new BigDecimal(points[j].x - points[i].x);
                BigDecimal key = dy.divide(dx, MathContext.DECIMAL128);
                // double key = (double)(p_j.y - p_i.y) / (double)(p_j.x - p_i.x);
                // if (i == 0)
                    // System.out.println(key);
                map.put(key, map.getOrDefault(key, 1) + 1);
                result = Math.max(result, map.get(key) + samep);
            }
            result = Math.max(result, samex);
        }
        return result;
    }
}