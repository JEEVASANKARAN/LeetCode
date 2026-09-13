class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        int max = 0;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(img1[r][c] == 1) list1.add(new int[]{r,c});
                if(img2[r][c] == 1) list2.add(new int[]{r,c});
            }
        }

        int[][] counter = new int[2*n][2*n];

        for(int[] a : list1){
            for(int[] b : list2){
                int x = a[0] - b[0] + n;
                int y = a[1] - b[1] + n;

                max = Math.max(max, ++counter[x][y]);
            }
        }
        return max;
    }
}