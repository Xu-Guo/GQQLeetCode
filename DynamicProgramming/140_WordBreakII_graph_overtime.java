public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Graph gwa = new Graph();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (wordDict.contains(s.substring(i, j))) {
                    // debug: test the graph structure.
                    // System.out.println(i + "--->" + j);
                    gwa.addEdge(i, j);
                }
            }
        }

        LinkedList<Integer> visited = new LinkedList<>();
        visited.add(0);
        LinkedList<LinkedList<String>> lstResults = new LinkedList<>();
        depthFirstFindPaths(s, gwa, visited, len, lstResults);

        LinkedList<String> results = new LinkedList<>();
        for (LinkedList<String> lst : lstResults) {
            String join = String.join(" ", lst);
            results.add(join);
        }
        return results;
    }

    public void depthFirstFindPaths(String s, Graph graph, LinkedList<Integer> visited, Integer end,
            LinkedList<LinkedList<String>> results) {
        Integer ele = visited.getLast();
        LinkedList<Integer> adjacentNodes = graph.adjacentNodes(ele);
        for (Integer i : adjacentNodes) {
            if (i.equals(end)) {
                LinkedList<String> tmp = new LinkedList<>();
                // test visited array.
                // visited.forEach(x -> System.out.print(x + " "));
                // System.out.println();
                for (int j = 1; j < visited.size(); j++) {
                    tmp.add(s.substring(visited.get(j - 1), visited.get(j)));
                }
                tmp.add(s.substring(visited.getLast(), end));
                results.add(tmp);
            }
        }
        for (Integer i : adjacentNodes) {
            if (!visited.contains(i) && !i.equals(end)) {
                visited.add(i);
                depthFirstFindPaths(s, graph, visited, end, results);
                visited.removeLast();
            }
        }
    }
}

class Graph {
    // Adjacency list
    private Map<Integer, LinkedHashSet<Integer>> map = new HashMap<>();

    public void addEdge(Integer node1, Integer node2) {
        LinkedHashSet<Integer> adjacent = map.get(node1);
        if (adjacent == null) {
            adjacent = new LinkedHashSet<Integer>();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }

    public boolean isConnected(Integer node1, Integer node2) {
        Set adjacent = map.get(node1);
        if (adjacent == null) {
            return false;
        }
        return adjacent.contains(node2);
    }

    public LinkedList<Integer> adjacentNodes(Integer last) {
        LinkedHashSet<Integer> adjacent = map.get(last);
        if (adjacent == null) {
            return new LinkedList<Integer>();
        }
        return new LinkedList<Integer>(adjacent);
    }
}
