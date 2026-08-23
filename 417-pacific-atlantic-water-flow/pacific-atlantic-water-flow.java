class Solution {
    int[][] directions={
        {-1,0},{1,0},
        {0,-1},{0,1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        List<List<Integer>> result=new ArrayList<>();
        boolean[][] atlantic=new boolean[m][n];
        boolean[][] pacific=new boolean[m][n];

        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) dfs(i,j,pacific,heights);
                if(i==m-1 || j==n-1) dfs(i,j,atlantic,heights);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }
    public void dfs(int r, int c,boolean[][] ocean,int[][] heights){
        ocean[r][c]=true;
        for(int[] direction : directions){
            int nr=direction[0] + r;
            int nc=direction[1] + c;

            if(nr>=0 && nr<ocean.length && nc>=0 && nc<ocean[0].length && !ocean[nr][nc] && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,ocean,heights);
            }
        }
    }
}