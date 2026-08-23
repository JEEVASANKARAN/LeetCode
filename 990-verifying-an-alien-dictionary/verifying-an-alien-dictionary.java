class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1)
            return true;
        int[] rank = new int[26];
        for (int i = 0; i < order.length(); i++)
            rank[order.charAt(i) - 'a'] = i;

        for (int i = 1; i < words.length; i++) {
            int l = 0;
            int r = 0;
            while (l < words[i - 1].length() && r < words[i].length()) {

                int a = rank[words[i - 1].charAt(l) - 'a'];
                int b = rank[words[i].charAt(r) - 'a'];

                if (a > b)
                    return false;

                if (a < b)
                    break;

                l++;
                r++;
            }
            if (r == words[i].length() && l < words[i - 1].length())
                return false;
        }
        return true;
    }
}