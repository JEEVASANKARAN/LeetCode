class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> allowed = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(startGene);
        visited.add(startGene);

        int turns = 0;
        char[] choices = { 'A', 'C', 'G', 'T' };

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String curr = q.poll();
                if (curr.equals(endGene)) return turns;

                for (int i = 0; i < 8; i++) {
                    for (char c : choices) {

                        if (c == curr.charAt(i))continue;

                        String strand = curr.substring(0, i) +c +curr.substring(i + 1);

                        if (allowed.contains(strand) && !visited.contains(strand)) {

                            visited.add(strand);
                            q.add(strand);
                        }
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}