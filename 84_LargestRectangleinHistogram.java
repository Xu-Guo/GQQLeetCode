public class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Record> records = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            if (records.isEmpty()) {
                records.push(new Record(height, 1));
                // max = Math.max(max, height);
            } else {
                Record top = records.peek();
                if (top.hgt < height) {
                    records.push(new Record(height, 1));
                } else {
                    // loop stack until top smaller than height
                    int total = 0;
                    while (!records.isEmpty() && records.peek().hgt >= height) {
                        Record rcd = records.pop();
                        total += rcd.number;
                        max = Math.max(max, rcd.hgt * total);
                    }
                    records.push(new Record(height, total + 1));
                }
            }
        }

        int total = 0;
        while (!records.isEmpty()) {
            Record rcd = records.pop();
            total += rcd.number;
            max = Math.max(max, rcd.hgt * total);
        }
        return max;
    }
}

class Record {
    int hgt;
    int number;
    public Record(int hi, int num) {
        this.hgt = hi;
        this.number = num;
    }
}