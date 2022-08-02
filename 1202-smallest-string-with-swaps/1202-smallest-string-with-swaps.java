class Solution {
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
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DSU sets = new DSU(s.length());
        
        for(List<Integer> pair: pairs){
            sets.union(pair.get(0), pair.get(1));
        }
        
        // Parent -> Components Nodes
        HashMap<Integer, ArrayList<Character>> Char = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> Idx = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            int parent = sets.find(i);
            if(Idx.containsKey(parent) == false){
                Char.put(parent, new ArrayList<>());
                Idx.put(parent, new ArrayList<>());
            }
            
            Char.get(parent).add(s.charAt(i));
            Idx.get(parent).add(i);
        }
        
        for(Integer parent: Char.keySet()) {
            Collections.sort(Char.get(parent));
            
            System.out.println(parent + " : ");
            System.out.println(Idx.get(parent));
            System.out.println(Char.get(parent));
        }
        
        StringBuilder res = new StringBuilder(s);
        
        for(Integer parent: Idx.keySet()){
            for(int j=0; j<Char.get(parent).size(); j++){
                int idx = Idx.get(parent).get(j);
                char ch = Char.get(parent).get(j);
                res.setCharAt(idx, ch);
            }
        }
        
        return res.toString();
    }
}