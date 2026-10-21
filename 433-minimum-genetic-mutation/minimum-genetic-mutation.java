class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        if (!bankSet.contains(end)) return -1;

        char[] genes = {'A','C','G','T'};
        q.offer(start);
        visited.add(start);

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(end)) return steps;
                char[] arr = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char old = arr[j];
                    for (char g : genes) {
                        arr[j] = g;
                        String next = new String(arr);
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            steps++;
        }
        return -1;
    }
}