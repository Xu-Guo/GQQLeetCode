public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] vertices = new int[n];
        for (int i = 0; i < n; i++) vertices[i] = i;

        for (int[] edge : edges) {
            int p_start = find(edge[0], vertices);
            int p_end = find(edge[1], vertices);
            if (p_start != p_end) {
                n--;
                vertices[p_start] = vertices[p_end]; // union
            }
        }
        return n;
    }

    // by using this method. finding is o(n) and union is o(1)
    public int find(int idx, int[] vertices) {
        if (idx == vertices[idx]) {
            return idx;
        }
        return find(vertices[idx], vertices);
    }
}
