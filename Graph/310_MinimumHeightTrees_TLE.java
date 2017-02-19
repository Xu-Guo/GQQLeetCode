public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> lst = new ArrayList<>();
        for (int i=0; i<n; i++) {
            Set<Integer> nodes = new HashSet<>();
            lst.add(nodes);
        }

        for (int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            lst.get(edge[0]).add(edge[1]);
            lst.get(edge[1]).add(edge[0]);
        }

        int deepest = n;
        Set<Integer> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            visited.clear();
            int deep = dfs(i, lst, visited);
            if (deep < deepest) {
                res.clear();
                res.add(i);
                deepest = deep;
            } else if (deep == deepest) {
                res.add(i);
            }
        }
        // int test = dfs(3, lst, visited);
        // System.out.println(test);
        return res;
    }

    private int dfs(int curr, List<Set<Integer>> list, Set<Integer> visited) {
        int deep = 1;
        visited.add(curr);
        Set<Integer> nodes = list.get(curr);
        int subdeep = 0;
        for (int node : nodes) {
            if (!visited.contains(node)) {
                subdeep = Math.max(subdeep, dfs(node, list, visited));
            }
        }
        return deep + subdeep;
    }
}