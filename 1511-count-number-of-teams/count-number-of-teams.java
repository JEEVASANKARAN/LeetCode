class Solution {
    public int numTeams(int[] rating) {
        int res=0;
        for(int i=0;i<rating.length;i++){
            res+=(inC(i,rating)+deC(i,rating));
        }
        return res;
    }
    public int deC(int index,int[] rating){
        if(index==0) return 0;
        if(index==rating.length-1) return 0;
        int countL=0;
        for(int i=0;i<index;i++){
            if(rating[i]>rating[index]){
                countL++;
            }
        }
        int countR=0;
        for(int i=index+1;i<rating.length;i++){
            if(rating[i]<rating[index]){
                countR++;
            }
        }
        return countL*countR;
    }
    public int inC(int index,int[] rating){
        if(index==0) return 0;
        if(index==rating.length-1) return 0;
        int countL=0;
        for(int i=0;i<index;i++){
            if(rating[i]<rating[index]){
                countL++;
            }
        }
        int countR=0;
        for(int i=index+1;i<rating.length;i++){
            if(rating[i]>rating[index]){
                countR++;
            }
        }
        return countL*countR;
    }
}