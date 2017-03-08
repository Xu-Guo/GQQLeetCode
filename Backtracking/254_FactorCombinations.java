public class Solution {
    public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2);
    }
    public List<List<Integer>> getFactors(int n, int start) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                int other = n / i;
                results.add(Arrays.asList(i, other));
                List<List<Integer>> subResults = getFactors(other, i);
                for (List<Integer> sub : subResults) {
                    List<Integer> sublist = new ArrayList<Integer>();
                    sublist.add(i);
                    sublist.addAll(sub);
                    results.add(sublist);
                }
            }
        }
        return results;
    }
}

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<Integer>(), n, 2);
        return list;
    }
    public void helper(List<List<Integer>> list, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1)
                list.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                helper(list, item, n / i, i);
                item.remove(item.size() - 1);
            }

        }
    }
}