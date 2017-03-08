public class Solution {
    // used must be int array
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int mci = maxChoosableInteger;
        int sum = mci * (mci + 1) / 2;
        if (sum < desiredTotal) return false;
        int[] used = new int[mci + 1];

        return helper(mci, used, desiredTotal, new HashMap<String, Boolean>());
    }

    public boolean helper(int mci, int[] used, int desiredTotal, Map<String, Boolean> cache) {
        String key = Arrays.toString(used);
        if (cache.containsKey(key)) return cache.get(key);

        // if (desiredTotal <= 0) {
        //     cache.put(key, false);
        //     return false;
        // }

        for (int i = 1; i <= mci; i++) {
            if (used[i] == 1) continue;
            if (i >= desiredTotal) {
                cache.put(key, true);
                return true;
            }
            used[i] = 1;
            boolean res = helper(mci, used, desiredTotal - i, cache);
            used[i] = 0;
            if (!res) {
                cache.put(key, true);
                return true;
            }
        }
        cache.put(key, false);
        return false;
    }
}