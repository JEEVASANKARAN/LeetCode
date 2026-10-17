class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][3];

        for(int i = 0; i < n; i++){
            int sum = 0, x = nums[i];

            for(; x > 0; x /= 10) sum += x % 10;

            arr[i][0] = sum;
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a,b) -> a[0] != b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1]));

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for(int i = 0; i < n; i++){
            if(visited[i] || arr[i][2] == i) continue;
            int j = i, len = 0;
            while(!visited[j]){
                visited[j] = true;
                j = arr[j][2];
                len++;
            }
            swaps += len -1;
        }
        return swaps;
    }
}