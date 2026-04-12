class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res=new int[n];
        for(int[] a:bookings){
            int l=a[0]-1;
            int r=a[1]-1;
            int seats=a[2];
            res[l]+=seats;
            if(r+1<n){
                res[r+1]-=seats;
            }
        }
        for(int i=1;i<n;i++){
            res[i]+=res[i-1];
        }
        return res;
    }
}