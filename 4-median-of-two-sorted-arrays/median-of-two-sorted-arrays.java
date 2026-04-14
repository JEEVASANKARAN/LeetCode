import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
int[] res=merge(nums1,nums2);
Arrays.sort(res);
if(res.length%2==0){
double data=((res[res.length/2-1])+(res[res.length/2]))/2.0;
return data;
}
else{
    double data=res[res.length/2];
    return data;
}
    }
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

}