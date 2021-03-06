public class Solution {
    public int[] singleNumber(int[] nums) {
        // find one bit difference.
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;
        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}