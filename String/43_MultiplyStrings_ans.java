public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p = i + j, q = i + j + 1;
                int mult = Integer.parseInt(num1.charAt(i) + "") * Integer.parseInt(num2.charAt(j) + "");
                int sum = mult + res[q];
                res[q] = sum % 10;
                res[p] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            if (sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}