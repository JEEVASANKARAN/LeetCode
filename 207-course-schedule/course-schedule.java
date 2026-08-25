class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] p : prerequisites)
            graph.get(p[1]).add(p[0]);

        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {

                if (dfs(i, graph, visited, path))
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(
            int node,
            List<List<Integer>> graph,
            boolean[] visited,
            boolean[] path) {

        visited[node] = true;
        path[node] = true;

        for (int next : graph.get(node)) {

            if (!visited[next]) {

                if (dfs(next, graph, visited, path))
                    return true;

            } else if (path[next]) {

                return true;
            }
        }

        path[node] = false;

        return false;
    }
}