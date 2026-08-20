class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,isConnected,visited);
                count++;
            }
        }
        return count;
    }
    public void dfs(int node, int[][] graph,boolean[] visited){
        visited[node]=true;
        for(int i=0;i<graph.length;i++){
            if(graph[node][i]==1 && !visited[i]){
                dfs(i,graph,visited);
            }
        }
    }
}