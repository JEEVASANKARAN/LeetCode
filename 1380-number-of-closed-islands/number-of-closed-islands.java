class Solution {
    int count = 0;
    int[][] directions = {
        {-1,0},{1,0},
        {0,-1},{0,1}
    };
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 0) dfs( i, j, grid);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    dfs( i, j, grid);
                    count++;
                } 
            }
        }
        return count;
    }
    public void dfs(int r, int c, int[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1) return;

        grid[r][c] = 1;

        for(int[] direction : directions){
            int nr = r + direction[0];
            int nc = c + direction[1];

            dfs(nr,nc,grid);
        }
    }
}