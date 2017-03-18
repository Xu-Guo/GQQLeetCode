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

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        for (int i = 0; i < numCourses; i++) {
            if (!seccessed[i])
                res = res && check(i, courses, seccessed, visited);
            if(!res) break;
        }
        return res;
    }

    public boolean check(int curr, Set<Integer>[] courses, boolean[] seccessed, boolean[] visited) {
        Set<Integer> prereqs = courses[curr];
        if (prereqs.size() == 0) {
            seccessed[curr] = true;
            return true;
        }
        if (visited[curr]) return false;
        visited[curr] = true;
        for (Integer p : prereqs) {
            if (seccessed[p]) continue;
            boolean res = check(p, courses, seccessed, visited);
            if (!res) return false;
        }
        visited[curr] = false;
        seccessed[curr] = true;
        return true;
    }
}