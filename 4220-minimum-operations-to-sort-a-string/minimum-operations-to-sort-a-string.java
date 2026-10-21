class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int min = 0;
        int max = 0;
        boolean ok = true;

        for( int i = 1; i < n; i++){
            char c = s.charAt(i);

            if(s.charAt(i - 1) > c) ok = false;

            if(c > s.charAt(max)) max = i;
            if(c < s.charAt(min)) min = i;
        }

        if(ok) return 0;
        if(n == 2) return -1;
        if(s.charAt(min) == s.charAt(0) || s.charAt(max) == s.charAt(n-1)) return 1;

        for (int i = 1; i < n - 1; i++){
            if (s.charAt(i) == s.charAt(min) || s.charAt(i) == s.charAt(max)) return 2;
        }

        return 3;

    }
}