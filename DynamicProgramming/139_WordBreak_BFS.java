public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) return true;
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while(!queue.isEmpty()) {
            int point = queue.poll();
            for (int j=point+1; j<=s.length(); j++) {
                if(visited.contains(j)) continue;
                String sub = s.substring(point, j);
                if (wordDict.contains(sub)) {
                    if(j == s.length()) return true;
                    queue.offer(j);
                    visited.add(j);
                }
            }
        }
        return false;
    }
}