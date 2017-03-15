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
        if (node == null) return null;
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        // List<UndirectedGraphNode> neighbors = node.neighbors;
        new.neighbors = new ArrayList<>(node.neighbors);

    }
    public void copyOne(UndirectedGraphNode node, )
}