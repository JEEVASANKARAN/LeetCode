class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] freq = new int[n+1];

        for(int[] arr : trust){
            freq[arr[0]]--;
            freq[arr[1]]++;
        }
        for(int i=1 ; i<=n ; i++){
            if(freq[i] == n-1) return i;
        }
        return -1;
    }
}