class Solution {
    public String[] createGrid(int m, int n) {

        String[] res = new String[m];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) sb.append('.');

        res[0] = sb.toString();
        sb.setLength(0);

        for(int i = 0; i < n - 1; i++) sb.append('#');
        sb.append('.');
        String s = sb.toString();

        for(int i = 1; i < m; i++) res[i] = s;

        
        return res;
    }
}