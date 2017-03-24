public class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

public class Solution {
    public int getSum(int a, int b) {
        int pre = 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int a1 = a >> i & 1;
            int b1 = b >> i & 1;
            int val = pre ^ a1 ^ b1;
            int cnt = 0;
            if (a1 == 1) ++cnt;
            if (b1 == 1) ++cnt;
            if (pre == 1) ++cnt;
            pre = cnt >= 2 ? 1 : 0;
            sum |= val << i;
        }
        return sum;
    }
}