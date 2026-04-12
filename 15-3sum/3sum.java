class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int low=0; low<nums.length-2;low++){
            int mid= low+1;
            int high=nums.length-1;
            if(low>0&&nums[low]==nums[low-1]) continue;
            while(mid<high){
                int sum=nums[low]+nums[mid]+nums[high];
                if(sum==0){
                    list.add(Arrays.asList(nums[low],nums[mid],nums[high]));
                    mid++;
                    high--;
                    while(mid<high&&nums[mid]==nums[mid-1]) mid++;
                }
                else if(sum<0){
                    mid++;
                }
                else{
                    high--;
                }
            }
        }
        return list;
    }
}