public class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? myPositivePow(x, n) : 1 / myPositivePow(x, -n);
    }

    public double myPositivePow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double val = myPositivePow(x, n / 2);
        return n % 2 == 0 ? val * val : val * val * x;
    }
}