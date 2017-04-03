public class Solution {
    public List<List<Integer>> getFactors(int n) {
        // return helper(n, 2);
        List<List<Integer>> res = new ArrayList<>();
        helper(n, new ArrayList<Integer>(), res, 2);
        res.remove(res.size() - 1);
        return res;
    }

    // public List<List<Integer>> helper(int n, int start) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     for (int i = start; i <= Math.sqrt(n); i++) {
    //         if (n % i == 0) {
    //             int remain = n / i;
    //             List<Integer> first = new ArrayList<Integer>();
    //             first.add(i);
    //             first.add(remain);
    //             res.add(first);
    //             List<List<Integer>> subList = helper(remain, i);
    //             for (List<Integer> sub : subList) {
    //                 List<Integer> second = new ArrayList<>(sub);
    //                 second.add(0, i);
    //                 res.add(second);
    //             }
    //         }
    //     }
    //     return res;
    // }

    public void helper(int n, List<Integer> tmp, List<List<Integer>> res, int start) {
        if (n <= 1) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i != 0) continue;
            tmp.add(i);
            helper(n / i, tmp, res, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}