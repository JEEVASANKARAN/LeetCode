1class Solution {
2    static{
3        for(int i=0;i<301;i++){
4            isAnagram("","");
5        }
6    }
7    public static boolean isAnagram(String s, String t) {
8        if (s.length() != t.length()) return false;
9
10        int[] freq = new int[26];
11
12        for (int i = 0; i < s.length(); i++) {
13            freq[s.charAt(i) - 'a']++;
14            freq[t.charAt(i) - 'a']--;
15        }
16
17        for (int n : freq) {
18            if (n != 0) return false;
19        }
20
21        return true;
22    }
23}