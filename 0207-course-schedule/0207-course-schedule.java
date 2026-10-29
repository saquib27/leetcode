class Solution {

    boolean[] isVisited;
    boolean[] isExplored;
    List<Integer>[] graph;

    private boolean isCycle(int course) {

        isVisited[course] = true;

        for (int newCourse : graph[course]) {
            if (!isVisited[newCourse] && isCycle(newCourse)) {
                return true;
            }
            if (!isExplored[newCourse]) {
                return true;
            }
        }

        isExplored[course] = true;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        graph = new List[numCourses];
        isVisited = new boolean[numCourses];
        isExplored = new boolean[numCourses];

        for (int course = 0; course < numCourses; course++) {
            graph[course] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!isVisited[course] && isCycle(course)) {
                return false;
            }
        }

        return true;
    }
}