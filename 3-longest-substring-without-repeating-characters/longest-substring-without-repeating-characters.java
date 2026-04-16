class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128]; // fixed size
        Arrays.fill(map, -1);

        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map[c] >= left) {
                left = map[c] + 1;
            }

            map[c] = right;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}