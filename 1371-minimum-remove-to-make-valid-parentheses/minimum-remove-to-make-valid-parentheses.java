class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);

        for( int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);

            if(c == '(') count++;

            else if(c == ')'){
                if(count > 0) count--;
                else{
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }

        for(int i = sb.length()-1; i >= 0 && count > 0; i--){
            if(sb.charAt(i) == '('){
                sb.deleteCharAt(i);
                count--;
            }
        }
        
        return sb.toString();
    }
}