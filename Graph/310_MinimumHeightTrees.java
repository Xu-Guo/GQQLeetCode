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

        Set<Integer> leaves = new HashSet();
        for (int i=0; i<lst.size(); i++) {
            // i is a leaf node
            if (lst.get(i).size() == 1) leaves.add(i);
        }

        int leftnodes = n;
        while (leftnodes > 2) {
            leftnodes -= leaves.size();
            Set<Integer> newLeaves = new HashSet<>();
            for (int leaf : leaves) {
                int j = lst.get(leaf).iterator().next();
                lst.get(j).remove(leaf);
                if (lst.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        if (leaves.isEmpty()) leaves.add(0);
        return new ArrayList<Integer>(leaves);
    }
}