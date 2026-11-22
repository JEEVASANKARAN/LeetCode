class Solution {
    public boolean checkString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String res = new String(arr);

        return s.equals(res);
    }
}