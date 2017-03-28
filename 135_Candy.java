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
        int[] newratings = new int[n + 2];
        int[] res = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            res[i] = 1;
        }

        newratings[0] = Integer.MAX_VALUE;
        newratings[n + 1] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            newratings[i + 1] = ratings[i];
        }

        // find bottoms
        bottoms.add(0);
        for (int i = 1; i <= n; i++) {
            if (newratings[i] <= newratings[i - 1] && newratings[i] <= newratings[i + 1]) {
                bottoms.add(i);
                res[i] = 1;
            }
        }
        bottoms.add(n + 1);

        int size = bottoms.size();
        // 1. from 1 to size - 1
        for (int i = 1; i < size - 1; i++) {
            int low = bottoms.get(i);
            int high = bottoms.get(i + 1);
            for (int j = low; j < high; j++) {
                if (newratings[j] < newratings[j + 1]) {
                    int newVal = res[j] + 1;
                    res[j + 1] = Math.max(newVal, res[j + 1]);
                }
            }
        }

        // 2.from size - 2 to 0
        for (int i = size - 2; i > 0; i--) {
            int high = bottoms.get(i);
            int low = bottoms.get(i - 1);
            for (int j = high; j > low; j--) {
                if (newratings[j] < newratings[j - 1]) {
                    int newVal = res[j] + 1;
                    res[j - 1] = Math.max(res[j - 1], newVal);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += res[i];
        }
        return sum;
    }
}