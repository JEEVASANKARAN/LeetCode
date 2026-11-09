class Solution {
    int[][] directions = {
        {-1,-1}, {-1,0}, {-1, 1},
        {0,-1}, {0,1},
        {1,-1}, {1,0}, {1,1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], step = curr[2];

           // System.out.println(r + " " + c);
            if(r == n - 1 && c == n - 1) min = Math.min(min, step);
               

            for(int[] direction : directions){
                int nr = direction[0] + r;
                int nc = direction[1] + c;

                if(nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] == 1 || step + 1 >= min) continue;
                q.add(new int[]{nr,nc, step + 1});
                grid[nr][nc] = 1;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}