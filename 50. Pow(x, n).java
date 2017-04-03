public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) return doPow(x, n);
        return 1 / doPow(x, -n);
    }
    
    public double doPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double sub = doPow(x, n / 2);
        if (n % 2 == 0) {
            return sub * sub;
        }
        return sub * sub * x;
    }
}