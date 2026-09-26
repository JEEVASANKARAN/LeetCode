class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(var k : knowledge) map.put(k.get(0),k.get(1));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                int j = s.indexOf(")", i + 1);
                sb.append(map.getOrDefault(s.substring( i+1, j), "?"));
                i = j;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}