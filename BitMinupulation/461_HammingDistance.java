public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        for (int i= 0; i<32; i++) {
            cnt += z & 1;
            z >>= 1;
        }
        return cnt;
    }
}