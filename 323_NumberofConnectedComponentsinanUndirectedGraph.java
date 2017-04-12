public class Solution {
    public int countComponents(int n, int[][] edges) {
        Graph g = new Graph(n, edges);
        return g.countComponents();
    }
}

class Graph {
    int[] vertices;
    int[][] edges;
    public Graph(int n, int[][] edges) {
        vertices = new int[n];
        for (int i = 0; i < n; i++) vertices[i] = i;
        this.edges = edges;
    }

    public int find(int i) {
        return vertices[i];
    }

    // union is o(n). find is o(1)
    public void union(int i, int j) {
        int src = vertices[i];
        int dest = vertices[j];
        for (int k = 0; k < vertices.length; k++) {
            if (vertices[k] == src) vertices[k] = dest;
        }
    }

    public int countComponents() {
        if (edges == null || edges.length == 0) return vertices.length;
        int m = edges.length;
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if (find(start) != find(end)) {
                union(start, end);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int vertex : vertices) {
            set.add(vertex);
        }
        return set.size();
    }
}