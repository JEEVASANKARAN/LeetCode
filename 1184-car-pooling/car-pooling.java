class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr=new int[1001];
        for(int[] a:trips){
            int pass=a[0];
            int start=a[1];
            int end=a[2];

            arr[start]+=pass;
            arr[end]-=pass;
        }
        int curr=0;
        for(int i:arr){
            curr+=i;
            if(curr>capacity) return false;
        }
        return true;
    }
}