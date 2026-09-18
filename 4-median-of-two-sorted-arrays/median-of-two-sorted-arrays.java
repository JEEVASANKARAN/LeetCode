class Solution {     
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {         
        int[] res = sorted(nums1, nums2);         
        
        return res.length % 2 == 0 ? ((res[res.length / 2] + res[res.length / 2 - 1]) / 2.0) : res[res.length / 2];     
    }     

    int[] sorted(int[] a, int[] b) {         
        int[] res = new int[a.length + b.length];         
        int k = 0;         
        int i = 0;         
        int j = 0;         
        

        while (i < a.length || j < b.length) {             
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    res[k] = a[i];
                    i++;
                } else {
                    res[k] = b[j];
                    j++;
                }
            } 
            else if (i < a.length) {
                res[k] = a[i];
                i++;
            } 
            else {
                res[k] = b[j];
                j++;
            }
            k++;         
        }         
        return res;     
    } 
}