class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int boxNum = (i / 3) * 3 + (j / 3);

                    rows[i][num] = true;
                    cols[j][num] = true;
                    box[boxNum][num] = true; 
                }
            }
        }
        back(0, 0, rows, cols, box, board);
    }
    public boolean back(int row, int col, boolean[][] rows, boolean[][] cols, boolean[][] box, char[][] board){
        if(row == 9) return true;

        int nextRow = (col == 8) ? row + 1 : row, nextCol = (col + 1) % 9, boxNum = (row / 3) * 3 + (col / 3);
        if(board[row][col] != '.') return back(nextRow, nextCol, rows, cols, box, board);

        for(int i = 0; i < 9; i++){
            if(rows[row][i] || cols[col][i] || box[boxNum][i]) continue;

            board[row][col] = (char) (i + '1');
            rows[row][i] = true;
            cols[col][i] = true;
            box[boxNum][i] = true;

            if(back(nextRow, nextCol, rows, cols, box, board)) return true;
            
            board[row][col] = '.';
            rows[row][i] = false;
            cols[col][i] = false;
            box[boxNum][i] = false;

        }
        return false;
    }
}