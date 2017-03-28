public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int n = ratings.length;
        List<Integer> bottoms = new ArrayList<>();
        int[] rat = new int[n + 2];
        int[] res = new int[n + 2];
        rat[0] = Integer.MAX_VALUE;
        rat[n + 1] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            rat[i + 1] = ratings[i];
        }

        // find bottoms
        for (int i = 1; i <= n; i++) {
            if (rat[i] <= rat[i - 1] && rat[i] <= rat[i + 1]) {
                bottoms.add(i);
                res[i] = 1;
            }
        }

        // loop bottoms, update res.
        for (int i = 0; i < bottoms.size() - 1; i++) {
            for (int j = bottoms.get(i) + 1; j < bottoms.get(i + 1); j++) {
                if (rat[j] > rat[j + 1]) {
                    res[j + 1] = res[j] + 1;
                }
            }
        }
    }
}