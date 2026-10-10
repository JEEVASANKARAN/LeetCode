class Solution {
    public int minInsertions(String s) {
        int insert = 0;
        int rightNeed = 0;
        
        for(char c : s.toCharArray()){
            if(c == '('){
                rightNeed += 2;

                if(rightNeed % 2 == 1){
                    insert++;
                    rightNeed--;
                }
            }
            else{
                rightNeed--;

                if(rightNeed < 0){
                    insert++;
                    rightNeed += 2;
                }
            }
        }
        return insert + rightNeed;
    }
}