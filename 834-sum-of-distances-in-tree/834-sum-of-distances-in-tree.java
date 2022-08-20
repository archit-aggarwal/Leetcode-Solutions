class Solution {
    int[] sum, count;
    
    public void DFS1(int src, int par, ArrayList<Integer>[] adj){
        count[src] = 1;
        
        for(Integer nbr: adj[src]){
            if(nbr == par) continue;
            DFS1(nbr, src, adj);
            count[src] += count[nbr];
            sum[src] += (sum[nbr] + count[nbr]);
        }    
    }
    
    public void DFS2(int src, int par, ArrayList<Integer>[] adj){
        if(par != -1){
            sum[src] = sum[par] - count[src] + (adj.length - count[src]);    
        }
        
        for(Integer nbr: adj[src]){
            if(nbr == par) continue;
            DFS2(nbr, src, adj);
        }  
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        sum = new int[n];
        count = new int[n];
        
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        
        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        DFS1(0, -1, adj);
        DFS2(0, -1, adj);
        return sum;
    }
}