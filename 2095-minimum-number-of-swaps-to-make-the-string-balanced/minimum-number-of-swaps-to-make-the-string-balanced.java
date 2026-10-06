class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int count = 0;
        for( char c : s.toCharArray()){
            if(c == '[') open++;
            else{
                if(open > 0) open--;
                else count++;
            }
        }
        return (count+1)/2;
    }
}