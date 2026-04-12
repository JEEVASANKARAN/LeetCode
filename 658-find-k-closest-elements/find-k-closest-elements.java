class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list=new ArrayList<>();
        int left=0;
        int right=arr.length-1;
        while(right-left>=k){
            if(Math.abs(arr[right]-x)>=Math.abs(arr[left]-x)) right--;
            else left++;
        }
        for(int i=left;i<left+k;i++){
            list.add(arr[i]);
        }
        return list;
    }
}