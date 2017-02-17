public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        int currNum = 1;
        int curr = 1;
        while (currNum < n) {
            curr++;
            for (int prime : primes) {
                // curr is a super ugly number.
                if (curr % prime == 0 && set.contains(curr / prime)) {
                    set.add(curr);
                    ++currNum;
                    break;
                }
            }
        }
        return curr;
    }
}