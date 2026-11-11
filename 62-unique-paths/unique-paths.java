class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int[] a : arr) Arrays.fill(a,1);

        for(int i = m - 2; i > -1; i--){
            for(int j = n - 2; j > -1; j--){
                arr[i][j] = arr[i][j + 1] + arr[i + 1][j];
            }
        }
        return arr[0][0];
    }
}