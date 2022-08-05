class Solution {
    public static class Query implements Comparable<Query>{
        int idx;
        int a, b;
        int threshold;
        
        Query(int idx, int a, int b, int threshold){
            this.idx = idx;
            this.a = a; 
            this.b = b;
            this.threshold = threshold;
        }
            
        public int compareTo(Query other){
            return this.threshold - other.threshold;
        }
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
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        List<Query> sortedQueries = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            sortedQueries.add(new Query(i, queries[i][0], queries[i][1], queries[i][2]));
        }
        Collections.sort(sortedQueries);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        
        DSU sets = new DSU(n);
        boolean[] res = new boolean[queries.length];
        int e = 0;
        
        for(Query q: sortedQueries){
            while(e < edgeList.length && edgeList[e][2] < q.threshold){
                sets.union(edgeList[e][0], edgeList[e][1]);
                e++;
            }
            if(sets.find(q.a) == sets.find(q.b))
                res[q.idx] = true;
        }
        
        return res;
    }
}