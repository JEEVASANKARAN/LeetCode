class Solution {
    int[][] directions={
        {-1,0},{1,0},
        {0,-1},{0,1}
    };
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        visited[i][j] = 1;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row = curr.row;
            int col = curr.col;

            for(int[] direction : directions){
                int nr=direction[0] + row;
                int nc=direction[1] + col;

                if(nr>=0 && nc>=0 && nr<n && nc<m && visited[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    visited[nr][nc]=1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0) count++;
            }
        }
        return count;
    }
}