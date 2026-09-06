class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];

        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[r].length; c++){
                if(!visited[r][c]){
                    if(check(r,c,-1,-1,grid[r][c],grid,visited)) return true;
                }
            }
        }
        return false;
    }
    public boolean check(int r, int c, int pr, int pc, char target, char[][] grid, boolean[][] visited){
        visited[r][c]=true;
        
        for(int[] direction : directions){
            int nr= r+direction[0];
            int nc= c+direction[1];

            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc] == target){
                if(!visited[nr][nc]){
                    if(check(nr,nc,r,c,target,grid,visited)) return true;
                }
                else if(nr != pr || nc!=pc) return true;
            }
        }
        return false;
    }
}