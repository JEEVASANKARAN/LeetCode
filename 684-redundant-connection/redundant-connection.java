class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            boolean[] visited = new boolean[n + 1];

            if(dfs( u, v, graph, visited)) return edge;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    public boolean dfs(int node, int target, List<List<Integer>> graph, boolean[] visited){
        if(node == target) return true;

        visited[node] = true;

        for(int neigh : graph.get(node)){
            if(!visited[neigh]){
                if(dfs( neigh, target, graph, visited)) return true;
            }
        }
        return false;
    }
}