class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows)
            return s;

        char[][] grid = new char[numRows][s.length()];

        for (char[] gr : grid)
            Arrays.fill(gr, '_');

        int k = 0;
        int i = 0;
        int j = 0;
        boolean down = true;

        while (k < s.length()) {

            grid[i][j] = s.charAt(k);

            if (down) {
                if (i == numRows - 1) {
                    down = false;
                    i--;
                    j++;
                } else {
                    i++;
                }
            } else {
                if (i == 0) {
                    down = true;
                    i++;
                } else {
                    i--;
                    j++;
                }
            }

            k++;
        }

        StringBuilder sb = new StringBuilder();

        for (int m = 0; m < numRows; m++) {
            for (int n = 0; n < s.length(); n++) {
                if (grid[m][n] != '_')
                    sb.append(grid[m][n]);
            }
        }

        return sb.toString();
    }
}