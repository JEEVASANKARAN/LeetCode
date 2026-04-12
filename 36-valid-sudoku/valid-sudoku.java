class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] r=new boolean[9][9];
        boolean[][] c=new boolean[9][9];
        boolean[][] box=new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int num=board[i][j]-'1';
                int boxNum=(i/3)*3+(j/3);
                if(r[i][num]||c[j][num]||box[boxNum][num]) return false;
                r[i][num]=true;
                c[j][num]=true;
                box[boxNum][num]=true;
            }
        }
        return true;
    }
}