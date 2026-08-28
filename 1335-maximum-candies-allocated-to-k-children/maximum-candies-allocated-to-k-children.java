class Solution {
    public int maximumCandies(int[] candies, long k) {
        if(candies==null || candies.length==0) return 0;

        long max=0;
        for(int candy : candies) max=Math.max(candy,max);

        long low=1;
        long high=max;
        long result=0;
        while(low <= high){
            long mid = low + (high-low) /2;

            if(isDis(candies,mid,k)){
                result=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return (int)result;
    }
    public boolean isDis(int[] candies, long piles, long k){
        long totalCount=0;

        for(int candy : candies){
            totalCount+=(candy/piles);
        }
        return totalCount>=k;
    }

}