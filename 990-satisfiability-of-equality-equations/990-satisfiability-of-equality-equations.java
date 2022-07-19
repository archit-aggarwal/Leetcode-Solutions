class Solution {
    public void union(int v1, int v2, int[] par, int[] rank){
        v1 = find(v1, par);
        v2 = find(v2, par);
        
        if(v1 == v2) return;
        if(rank[v1] >= rank[v2]){
            par[v2] = v1;
            rank[v1] += rank[v2];
        }else {
            par[v1] = v2;
            rank[v2] += rank[v1];
        }
    }
    
    public int find(int v, int[] par){
        if(par[v] == -1) return v;
        return par[v] = find(par[v], par);
    }
    
    public boolean equationsPossible(String[] equations) {
        int[] par = new int[26];
        Arrays.fill(par, -1);
        int[] rank = new int[26];
        
        for(String eq: equations){
            int v1 = eq.charAt(0) - 'a';
            int v2 = eq.charAt(3) - 'a';
            
            if(eq.charAt(1) == '=') 
                union(v1, v2, par, rank);
        }
        
        for(String eq: equations){
            int v1 = eq.charAt(0) - 'a';
            int v2 = eq.charAt(3) - 'a';
            
            if(eq.charAt(1) == '!' && (v1 == v2 || find(v1, par) == find(v2, par))) 
                return false;
        }
        
        return true;
    }
}