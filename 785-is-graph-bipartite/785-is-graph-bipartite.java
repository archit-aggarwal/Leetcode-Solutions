class Solution {
    public boolean DFS(int src, int level, int[][] graph, int[] vis){
        if(vis[src] != -1){
            if(vis[src] != level % 2) return false;
            return true;
        }
        
        vis[src] = level % 2;
        for(int nbr: graph[src]){
            if(DFS(nbr, level + 1, graph, vis) == false){
                // Cycle of Odd Length
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);
        
        for(int i=0; i<graph.length; i++){
            if(vis[i] == -1 && DFS(i, 0, graph, vis) == false){
                return false;
            } 
        }
        
        return true;
    }
}