class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuffer pratik=new StringBuffer(s);
        int c=0;
        for(int i=0;i<pratik.length();i++){
            if(pratik.charAt(i)=='('){
                c++;
            }
            else if(pratik.charAt(i)==')'){
                if(c==0){
                    pratik.deleteCharAt(i);
                    i--;
                }
                else{
                    c--;
                }
            } 
        }
          for (int i = pratik.length() - 1; i >= 0 && c > 0; i--) {
            if(pratik.charAt(i)=='('){
                pratik.deleteCharAt(i);
                c--;
            }
        }
        return pratik.toString();
        
    }
}