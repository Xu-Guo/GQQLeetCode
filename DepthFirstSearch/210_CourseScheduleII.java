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

        boolean res = true;
        boolean[] seccessed = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!seccessed[i])
                res = res && check(i, courses, seccessed, visited, results);
            if(!res) break;
        }
        if (res) {
            int[] arrres = new int[numCourses];
            for (int i=0; i<numCourses; i++) {
                arrres[i] = results.get(i);
            }
            return arrres;
        }
        return new int[0];
    }

    public boolean check(int curr, Set<Integer>[] courses, boolean[] seccessed, boolean[] visited, List<Integer> results) {
        Set<Integer> prereqs = courses[curr];
        if (prereqs.size() == 0) {
            seccessed[curr] = true;
            results.add(curr);
            return true;
        }
        if (visited[curr]) return false;
        visited[curr] = true;
        for (Integer p : prereqs) {
            if (seccessed[p]) continue;
            boolean res = check(p, courses, seccessed, visited, results);
            if (!res) return false;
        }
        visited[curr] = false;
        seccessed[curr] = true;
        results.add(curr);
        return true;
    }
}