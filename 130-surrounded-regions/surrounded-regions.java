class Solution {
    int[][] directions = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] safe=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O') dfs(i,j,safe,board);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!safe[i][j] && board[i][j]=='O') board[i][j]='X';
            }
        }
    }

    public void dfs(int r, int c, boolean[][] safe, char[][] board) {
        safe[r][c] = true;

        for (int[] direction : directions) {
            int nr = direction[0] + r;
            int nc = direction[1] + c;

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && !safe[nr][nc]
                    && board[nr][nc] == 'O') {
                dfs(nr, nc, safe, board);
            }
        }
    }
}