public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] courses = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // courses.add(new HashSet<>());
            courses[i] = new HashSet<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        boolean istopping = true;
        boolean[] seccessed = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!seccessed[i])
                istopping = istopping && check(i, courses, seccessed, visited, results);
            if(!istopping) return new int[0];
        }

        int[] ret = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            ret[i] = results.get(i);
        }
        return ret;
    }

    public boolean check(int curr, Set<Integer>[] courses, boolean[] seccessed, boolean[] visited, List<Integer> results) {
        if (visited[curr]) return false;
        if (seccessed[curr]) return true;
        Set<Integer> prereqs = courses[curr];

        visited[curr] = true;
        for (Integer p : prereqs) {
            boolean res = check(p, courses, seccessed, visited, results);
            if (!res) return false;
        }
        visited[curr] = false;
        seccessed[curr] = true;
        results.add(curr);
        return true;
    }
}