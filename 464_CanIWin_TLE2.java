public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=maxChoosableInteger; i++) {
            set.add(i);
        }
        return helper(set, new HashSet<Integer>(), desiredTotal);
    }

    public boolean helper(Set<Integer> set, Set<Integer> excluded, int desiredTotal) {
        int sum = 0;
        // set.forEach(x -> sum += x);
        for (Integer num : set) {
            if (excluded.contains(num)) continue;
            if (num >= desiredTotal) return true;
            sum += num;
        }
        if (sum < desiredTotal) return false;
        for (Integer num : set) {
            // System.out.println(num);
            if (excluded.contains(num)) continue;
            excluded.add(num);
            boolean r = helper(set, excluded, desiredTotal - num);
            excluded.remove(num);
            if (!r) return true;
        }
        return false;
    }
}