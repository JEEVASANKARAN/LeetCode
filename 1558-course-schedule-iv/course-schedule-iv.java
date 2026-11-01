class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for(int[] courses : prerequisites){
            int pre = courses[0];
            int course = courses[1];

            indegree[course]++;
            graph.get(pre).add(course);
        }

        List<Boolean> res = new ArrayList<>();

        for(var query: queries){
            if(dfs(query[0], graph, query[1])) res.add(true);
            else res.add(false);
        }
        // Map<Integer, HashSet<Integer>> map = new HashMap<>();
        // for(int i = 0; i < numCourses; i++) map.put(i, new HashSet<>());

        // Queue<Integer> q = new LinkedList<>();
        // for(int i = 0; i < numCourses; i++){
        //     if(indegree[i] == 0) q.add(i);
        // }

        // while(!q.isEmpty()){

        //     int curr = q.poll();

        //     for(int num : graph.get(curr)){
        //         map.get(num).add(curr);
        //         map.get(num).addAll(map.get(curr));


        //         indegree[num]--;
        //         if(indegree[num] == 0) q.add(num);
        //     }
        // }

        // List<Boolean> res = new ArrayList<>();

        // for(int[] query : queries){
        //     res.add(map.get(query[1]).contains(query[0]));
        // }

        return res;
    }

    public boolean dfs(int node, List<List<Integer>> graph, int goal){
        if(node == goal) return true;

        for(int next : graph.get(node)){

            if(dfs(next, graph, goal)) return true;
        }

        return false;
    }
}