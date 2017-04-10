public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n ,n);
    }

    public List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("1", "8", "0"));

        List<String> substrs = helper(n - 2, m);

        List<String> res = new ArrayList<>();
        for (String sub : substrs) {
            if (n != m) res.add("0" + sub + "0");
            res.add("1" + sub + "1");
            res.add("8" + sub + "8");
            res.add("9" + sub + "6");
            res.add("6" + sub + "9");
        }
        return res;
    }

}