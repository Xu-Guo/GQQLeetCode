public class Solution {
    public int removeBoxes(int[] boxes) {
        Map<String, Integer> cache = new HashMap<>();
        return helper(boxes, cache);
    }

    public int helper(int[] boxes, Map<String, Integer> cache) {
        if (boxes.length == 0) return 0;
        if (boxes.length == 1) return 1;
        String key = Arrays.toString(boxes);
        if (cache.contains(key)) return cache.get(key);
        int n = boxes.length;
        int st = 1;
        while (st < n && boxes[st] == boxes[st - 1]) st++;
        if (st == n) {
            cache.put(key, n * n);
            return n * n;
        }
        int max = 0;
        int i = 0, j = 1;
        while (j <= n) {
            if (j == n || boxes[i] != boxes[j]) {
                int m = n - (j - i);
                int[] newboxes = new int[m];
                int k = 0;
                for (int t = 0; t < i; t++) newboxes[k++] = boxes[t];
                for (int t = j; t < n; t++) newboxes[k++] = boxes[t];
                max = Math.max(max, (j - i) * (j - i) + removeBoxes(newboxes));
                i = j;
            }
            j++;
        }
        cache.put(key, max);
        return max;
    }
}