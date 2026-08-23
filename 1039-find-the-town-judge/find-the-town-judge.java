class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n];
        int[] outdeg = new int[n];
        for (int[] edge : trust) {
            outdeg[edge[0]-1]++;
            indeg[edge[1]-1]++;
        }
        for (int i = 0; i < n; i++)
            if (indeg[i] == n - 1 && outdeg[i] == 0)
                return i+1;
        return -1;
    }
}