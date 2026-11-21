class Solution {
    List<List<Integer>> tree = new ArrayList<>();
    int[] lastSeen = new int[26];
    int[] ans;
    String s;
    int[] parent;
    public int[] findSubtreeSizes(int[] parent, String s) {
        this.parent = parent;
        this.s = s;
        ans = new int[parent.length];
        Arrays.fill(ans, 1);
        Arrays.fill(lastSeen, -1);
        for(int i = 0; i < parent.length; i++) tree.add(new ArrayList<>());
        for(int i = 1; i < parent.length; i++) tree.get(parent[i]).add(i);

        dfs(0);

        return ans;
    }

    public void dfs(int node){

        int c = s.charAt(node) - 'a';

        int prev = lastSeen[c];

        lastSeen[c] = node;

        for(int child : tree.get(node)){
            dfs(child);
        }

        lastSeen[c] = prev;

        if(node != 0){
            if(prev != -1) ans[prev] += ans[node];
            else ans[parent[node]] += ans[node];
        }
    }
}