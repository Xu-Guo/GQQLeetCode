public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new HashSet<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean res = true;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i))
                res = res && check(i, courses, visited, new HashSet<Integer>());
            if(!res) break;
        }
        return res;
    }

    public boolean check(int curr, List<Set<Integer>> courses, Set<Integer> visited, Set<Integer> parents) {
        Set<Integer> prereqs = courses.get(curr);
        if (prereqs.size() == 0) {
            visited.add(curr);
            return true;
        }
        if (parents.contains(curr)) return false;
        parents.add(curr);
        for (Integer p : prereqs) {
            if (visited.contains(p)) continue;
            boolean res = check(p, courses, visited, parents);
            if (!res) return false;
        }
        parents.remove(curr);
        visited.add(curr);
        return true;
    }
}