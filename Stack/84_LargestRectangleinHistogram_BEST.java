public class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> records = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int hi = heights[i];
            if (records.isEmpty() || heights[records.peek()] < hi) {
                records.push(i);
            } else {
                int right = 0;
                if (!records.isEmpty()) right = records.peek();
                while(!records.isEmpty() && heights[records.peek()] >= hi) {
                    max = Math.max(max, heights[records.pop()] * (records.isEmpty() ? right + 1 : right - records.peek()));
                }
                records.push(i);
            }
        }

        int right = 0;
        if (!records.isEmpty()) right = records.peek();
        while (!records.isEmpty()) {
            max = Math.max(max, heights[records.pop()] * (records.isEmpty() ? right + 1 : right - records.peek()));
        }
        return max;
    }
}
