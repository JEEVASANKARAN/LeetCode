class Solution {
    public int maximumCandies(int[] candies, long k) {
        if(candies==null || candies.length==0) return 0;

        int max=0;
        for(int candy : candies) max=Math.max(candy,max);

        int low=1;
        int high=max;
        int result=0;
        while(low <= high){
            int mid = low + (high-low) /2;

            if(isDis(candies,mid,k)){
                result=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return result;
    }
    public boolean isDis(int[] candies, int piles, long k){
        long totalCount=0;

        for(int candy : candies){
            totalCount+=(candy/piles);
        }
        return totalCount>=k;
    }

}