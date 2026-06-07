1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        if(nums1.length>nums2.length){
4           return findMedianSortedArrays(nums2,nums1);
5        }
6        int m=nums1.length;
7        int n=nums2.length;
8
9        int left=0;
10        int right=m;
11        while(left<=right){
12            int cut1=left+(right-left)/2;
13            int cut2=(m+n+1)/2-cut1;
14
15            int l1=(cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
16            int r1=(cut1==m)?Integer.MAX_VALUE:nums1[cut1];
17
18            int l2=(cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
19            int r2=(cut2==n)?Integer.MAX_VALUE:nums2[cut2];
20
21            if(l1<=r2&&l2<=r1){
22                if((m+n)%2==1){
23                    return Math.max(l1,l2);
24                }
25                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
26            }
27            else if(l1>r2){
28                right=cut1-1;
29            }
30            else{
31                left=cut1+1;
32            }
33        }
34        return 0.0;
35    }
36}