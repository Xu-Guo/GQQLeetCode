public class Solution {
    public String getPermutation(int n, int k) {
        if (n<=0 || k<=0 || n>9) {
            return "";
        }
        int[] fact = new int[n+1];
        fact[0] = 1;
        for (int i=1; i<=n; i++) {
            fact[i] = fact[i-1]*i;
        }
        if (k>fact[n]) {
            return "";
        }

        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        --k;
        for (int j=n-1; j>=0; j--) {
            int index = k / fact[j];
            sb.append(list.remove(index));
            k -= index*fact[j];
        }
        return sb.toString();
    }
}