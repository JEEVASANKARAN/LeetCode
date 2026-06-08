1/**
2 * // This is MountainArray's API interface.
3 * // You should not implement it, or speculate about its implementation
4 * interface MountainArray {
5 *     public int get(int index) {}
6 *     public int length() {}
7 * }
8 */
9 
10class Solution {
11    public int findInMountainArray(int target, MountainArray mountainArr) {
12        int peak=0;
13        int left=0;
14        int right=mountainArr.length()-1;
15        while(left<right){
16            int mid=left+(right-left)/2;
17            if(mountainArr.get(mid)<mountainArr.get(mid+1)) left=mid+1;
18            else right=mid;
19        }
20        peak=left;//left points to the peak
21        left=0;
22        right=peak;
23        while(left<=right){
24            int mid=left+(right-left)/2;
25            int val=mountainArr.get(mid);
26            if(val==target) return mid;
27            else if(val<target) left=mid+1;
28            else right=mid-1;
29        }
30        left=peak+1;
31        right=mountainArr.length()-1;
32        while(left<=right){
33            int mid=left+(right-left)/2;
34            int val=mountainArr.get(mid);
35            if(val==target) return mid;
36            else if(val<target) right=mid-1;
37            else left=mid+1;;
38        }
39        return -1;
40    }
41}