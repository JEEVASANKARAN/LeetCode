class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0;

        long count =0;

        for( int i =1; i < 6; i++){
            count += Math.max(0,n-Math.pow(10,3*i)+1);
        }
        return count;
    }
}