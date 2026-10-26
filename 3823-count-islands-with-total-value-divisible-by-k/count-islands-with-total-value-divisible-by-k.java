class Solution {
    long sum = 0;
    int[][] directions = {
        {-1,0}, {1,0},
        {0,-1}, {0,1}
    };
    public int countIslands(int[][] grid, int k) {
        int res = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) continue;

                sum = 0;
                dfs( i, j, grid);
                if(sum % k == 0) res++;
            }
        }
        return res;
    }

    public void dfs(int r, int c, int[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return;

        sum += grid[r][c];
        grid[r][c] = 0;

        for(int[] direction : directions){
            int nr = r + direction[0];
            int nc = c + direction[1];

            dfs(nr,nc,grid);
        }
    }

}