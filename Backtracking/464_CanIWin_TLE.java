public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=maxChoosableInteger; i++) {
            set.add(i);
        }
        return helper(set, desiredTotal);
    }

    public boolean helper(Set<Integer> set, int desiredTotal) {
        int sum = 0;
        // set.forEach(x -> sum += x);
        for (Integer num : set) {
            sum += num;
        }
        if (sum < desiredTotal) return false;
        for (Integer num : set) {
            if (num >= desiredTotal) return true;
        }
        Set<Integer> tmpSet = new HashSet<>(set);
        for (Integer num : set) {
            tmpSet.remove(num);
            boolean r = helper(tmpSet, desiredTotal - num);
            if (!r) return true;
            tmpSet.add(num);
        }
        return false;
    }
}