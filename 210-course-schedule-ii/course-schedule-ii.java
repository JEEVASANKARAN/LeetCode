class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for(int[] courses : prerequisites){
            int course = courses[0];
            int prereq = courses[1];

            indegree[course]++;

            graph.get(prereq).add(course);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int idx = 0;
        int[] res = new int[numCourses];

        while(!q.isEmpty()){

            int curr = q.poll();
            res[idx++] = curr;

            for(int num : graph.get(curr)){
                indegree[num]--;

                if(indegree[num] == 0) q.add(num);
            }
        }

        if(idx != numCourses) return new int[0];

        return res;
    }
}