class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public boolean isEdge(int a, int b, int threshold){
        if(gcd(a, b) > threshold) return true;
        return false;
    }
    
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
            Arrays.fill(rank, 1);
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb)
                return;

            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
                rank[pa] += rank[pb];
            } else {
                parent[pa] = pb;
                rank[pb] += rank[pa];
            }
        }

        public int find(int a) {
            if (parent[a] == -1)
                return a;
            return parent[a] = find(parent[a]);
        }
    }
    
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        DSU sets = new DSU(n + 1);
        for(int i=1; i<=n; i++)
            for(int j=i; j<=n; j=j+i)
                if(isEdge(i, j, threshold) == true)
                    sets.union(i, j);
        
        List<Boolean> ans = new ArrayList<>();
        for(int[] q: queries){
            if(sets.find(q[0]) == sets.find(q[1]))
                ans.add(true);
            else ans.add(false);
        }
        
        return ans;
    }
}