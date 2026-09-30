class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int count = 0;
        int res[] = new int[seq.length()];
        int idx = 0;
        for(char c : seq.toCharArray()){
            if(c == '('){
                res[idx++] = count % 2;
                count++;
            }
            else if(c == ')'){
                count--;
                res[idx++] = count % 2;
            }
        }
        return res;
    }
}