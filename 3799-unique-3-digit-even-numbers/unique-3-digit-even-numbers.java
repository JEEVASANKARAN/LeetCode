class Solution {
    int count=0;
    public int totalNumbers(int[] digits) {
        if(digits.length < 3) return 0;
        boolean[] visited = new boolean[digits.length];
        Arrays.sort(digits);
        back(new StringBuilder(), digits, visited);
        return count;
    }
    public void back(StringBuilder current, int[] digits, boolean[] visited){

        if(current.length() == 3){
            if(current.charAt(0) != '0' && Integer.parseInt(current.toString())%2 == 0 ) count++;
            return;
        }

        for(int i = 0; i < digits.length; i++){
            if(visited[i]) continue;
            if(i > 0 && digits[i] == digits[i-1] && !visited[i-1]) continue;

            visited[i] = true;
            current.append(digits[i]);
            back(current, digits, visited);
            visited[i] = false;
            current.deleteCharAt(current.length()-1);
        }
    }
}