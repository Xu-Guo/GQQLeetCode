/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return deepCopy(node, new HashMap<Integer, UndirectedGraphNode>());
    }

    public UndirectedGraphNode deepCopy(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        // List<UndirectedGraphNode> neighbors = node.neighbors;
        // new.neighbors = new ArrayList<>(node.neighbors);
        for (UndirectedGraphNode nb : node.neighbors) {
            if (nb.label == newnode.label) newnode.neighbors.add(newnode);
            else {
                // newnode.neighbors.add(cloneGraph(nb));
                if (map.containsKey(nb.label)) {
                    newnode.neighbors.add(map.get(nb.label));
                } else {
                    newnode.neighbors.add(deepCopy(nb, map));
                }
            }
        }
        map.put(newnode.label, newnode);
        return newnode;
    }
}