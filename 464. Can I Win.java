public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal > maxChoosableInteger * (maxChoosableInteger + 1)) return false;
        if (maxChoosableInteger >= desiredTotal) return true;
        int[] flags = new int[maxChoosableInteger + 1];
        Map<String, Boolean> map = new HashMap<>();
        return helper(maxChoosableInteger, desiredTotal, flags, map);
    }
    
    public boolean helper(int max, int desired, int[] flags, Map<String, Boolean> map) {
        // StringBuilder sb = new StringBuilder();
        // for (boolean flag : flags) {
        //     if (!flag) sb.append(0);
        //     else sb.append(1);
        // }
        String key = Arrays.toString(flags);
        if (map.containsKey(key)) return map.get(key);
        
        if (desired <= 0) return false;
        for (int i = 1; i <= max; i++) {
            if (flags[i] == 1) continue;
            flags[i] = 1;
            boolean other = helper(max, desired - i, flags, map);
            flags[i] = 0;
            if (!other) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}